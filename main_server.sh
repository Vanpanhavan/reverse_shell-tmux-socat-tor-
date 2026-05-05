#!/bin/bash


for PORT in {10000..19999}; do
        PORT_USED=$(ss -tunap | awk '{print $5}' | grep "$PORT") # this will get establish connection
        if [[  -z "$PORT_USED" ]]; then
                echo "$PORT"
                tmux new-window -n "$PORT" # create a tmux window with name base on port number\
		sleep 2
                tmux send-keys -t "$PORT" 'tty' C-m # execute tty inside new window
                sleep 2 # sleep is important so that new shell is ready for head, tail, grep for pty
                pty=$(tmux capture-pane -t "$PORT" -p | head -n 3 | tail -n 1) # pane capture in the new window
                tmux send-keys -t "$PORT" "socat OPENSSL-LISTEN:${PORT},cert=cert.pem,key=key.pem,verify=0,reuseaddr FILE:${pty},raw,echo=0" C-m
                bash delete_window.sh "$PORT" &
                break;
        else
                continue;
        fi
done

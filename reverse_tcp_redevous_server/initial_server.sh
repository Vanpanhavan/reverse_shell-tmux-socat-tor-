#!/bin/bash
# initial connection to client and triger main server

socat  OPENSSL-LISTEN:4444,cert=cert.pem,key=key.pem,verify=0,reuseaddr,fork EXEC:"./main_server.sh"

FROM python:3.11.9-alpine3.19

RUN pip install opcua

HEALTHCHECK --interval=1s --timeout=3s --retries=10 \
	CMD 'echo "exit()" | uaclient -u server:4840'


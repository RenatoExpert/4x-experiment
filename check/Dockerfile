FROM python:3.11.9-alpine3.19

RUN pip install opcua

HEALTHCHECK --interval=1s --timeout=3s \
	RUN 'echo "exit()" | uaclient -u server:4840'


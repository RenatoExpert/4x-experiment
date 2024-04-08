FROM python:3.11.9-alpine3.19
RUN pip install opcua
WORKDIR /server
COPY server/main.py .
ENTRYPOINT main.py


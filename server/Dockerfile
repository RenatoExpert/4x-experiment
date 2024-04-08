FROM python:3.11.9-alpine3.19
WORKDIR /server
RUN pip install opcua
COPY server/main.py .
ENTRYPOINT main.py


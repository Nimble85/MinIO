FROM ubuntu:latest
# Just an example
# It is need to install on client machine
# https://docs.min.io/docs/minio-client-quickstart-guide.html
RUN wget https://dl.min.io/client/mc/release/linux-amd64/mc && chmod +x mc
RUN export PATH=/bin/
COPY congig.json /root/.mc/congig.json



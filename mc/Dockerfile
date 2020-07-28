FROM ubuntu:latest
ENV MINIO_ACCESS_KEY admin_admin
ENV MINIO_SECRET_KEY admin_admin
ARG MinioServer http://192.168.1.51:9000
# Just an example
# It is need to install on client machine
# https://docs.min.io/docs/minio-client-quickstart-guide.html
RUN wget https://dl.min.io/client/mc/release/linux-amd64/mc && chmod +x mc
RUN export PATH=/bin/

# configure client
RUN mc config host add minio ${MinioServer} ${AccessKeyID} ${SecretAccessKey}
# Or just copy config file
COPY config.json /root/.mc/congig.json

#For example:
# mc config host add minio http://10.130.33.253:9000 admin_admin admin_admin
# mc config host add minigit o http://localhost:9000 admin_admin admin_admin
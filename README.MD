# MinIO

[![MinIO](https://raw.githubusercontent.com/minio/minio/master/.github/logo.svg?sanitize=true)](https://min.io)

# Start MinIO Server:
``
minio server --address :9000 /date
``
### Minio server variables:

```
MINIO_VOLUMES="/usr/local/share/minio"
MINIO_OPTS="-C /etc/minio --address :9000"
MINIO_ACCESS_KEY_FILE="/etc/minio/access_key"
MINIO_SECRET_KEY_FILE="/etc/minio/secret_key"
```
### MinIO start as System.d:
* https://github.com/minio/minio-service/tree/master/linux-systemd


#MinIO Client

### Inspect remote sources

```bash
mc ls minio
mc ls minio/bigbucket
```

### Create remote buckets:

``bash
mc mb minio/test-bucket001
``

### Remove file:

```bash
mc rm minio/bigbucket/Dockerfile
mc rm minio/bigbucket/Dockerfile.arm  minio/bigbucket/Dockerfile.arm64
```

### Copy to remote bucket

````bash
 mc cp winstone3732789767546353884.jar minio/test002/
 mc cp --recursive hsperfdata_root minio/test002
 mc cp --recursive ../${JOB_NAME} minio/test-bucket002
````

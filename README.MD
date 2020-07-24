# MinIO

[![MinIO](https://raw.githubusercontent.com/minio/minio/master/.github/logo.svg?sanitize=true)](https://min.io)

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

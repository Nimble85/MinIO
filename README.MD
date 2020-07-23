# MinIO

### Inspect remote sources

```
mc ls minio
mc ls minio/bigbucket
```

### Create remote buckets:

``
mc mb minio/test-bucket001
``

### Remove file:

```
mc rm minio/bigbucket/Dockerfile
mc rm minio/bigbucket/Dockerfile.arm  minio/bigbucket/Dockerfile.arm64
```

### Copy to remote bucket

````
 mc cp winstone3732789767546353884.jar minio/test002/
 mc cp --recursive hsperfdata_root minio/test002
````

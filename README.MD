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


# MinIO Client

For the first configure client, run the command:

````
mc config host add minio ${MinioServer} ${AccessKeyID} ${SecretAccessKey}
````
For example:

* mc config host add minio http://10.130.33.253:9000 admin_admin admin_admin
* mc config host add minio http://localhost:9000 admin_admin admin_admin


Or uses docker:
```
docker run -it --entrypoint=/usr/bin/mc minio/mc config host add test001 http://localhost:9000/ ${AccessKeyID} ${SecretAccessKey}
```

### Inspect remote sources

```bash
mc ls minio
mc ls minio/bigbucket
mc tree -d 1 minio
```

## Сontinue add some more configurations:

```bash
cat ~/.mc/config.json
```



```
mc admin info minio

mc admin policy list minio
```
```
mc admin user add minio/ minio-user minio-user
```
# Works with policies:

* Create a new user "developer"
```
mc admin user add minio/ developer DTHgOruTYjc19AHq
```
* Create new group "developers" and add user "developer" to this group
```
mc admin group add minio developers developer
```
* Import new policy in minio

```
mc admin policy add minio dev developers.json
```
* Apply policy "dev" to group "developers"
```
mc admin policy set minio dev group=developers
```

### Create remote buckets:

```bash
mc mb minio/test-bucket001
```

### Remove file:

```bash
mc rm minio/bigbucket/Dockerfile
mc rm minio/bigbucket/Dockerfile.arm  minio/bigbucket/Dockerfile.arm64
```
# IMPORTANT:

- If you will be use --recursive flag, it will be remove al directory which connect with the name. For example:
```
mcli rm --recursive --force minio/translated/2
```
Remove all directories which name in this path start from 2! It`s seems like:
```
mcli rm --recursive --force minio/translated/2
mcli rm --recursive --force minio/translated/21
mcli rm --recursive --force minio/translated/28
mcli rm --recursive --force minio/translated/2232
mcli rm --recursive --force minio/translated/2qws1
```

### Remove remote bucket:
```
mc rb --force minio/nameofbucket
```

### Copy to remote bucket

````bash
 mc cp winstone3732789767546353884.jar minio/test002/
 mc cp --recursive hsperfdata_root minio/test002
 mc cp --recursive ../${JOB_NAME} minio/test-bucket002
````

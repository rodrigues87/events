```
docker pull postgres
docker run --name postgresql -e POSTGRES_USER=assertuser -e POSTGRES_PASSWORD=123456 -p 5432:5432 -v /data:/var/lib/postgresql/data -d postgres
```
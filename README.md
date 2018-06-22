Token can be get by following API
  
  curl -XPOST -H "Content-type: application/json" -d '{
	"username" : "admin",
	"password" : "admin"
}' 'http://localhost:8090/login'



Testing API

curl -XPOST -H 'Authorization: Bearer <your-token>' 
-H "Content-type: application/json" 
'http://localhost:8090/api/getUsers'

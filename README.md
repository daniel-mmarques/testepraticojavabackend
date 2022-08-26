# Teste prático Java Backend


# Docker Compose
Este projeto utiliza docker compose, favor executar `docker-compose up` dentro da pasta do projeto

# Collection post
Existe na raiz do projeto uma collectio que pode ser importada no postman com os endpoints

# Tecnologias
Principais tecnologias utilizada: Java17, springboot, springdata, postgres, lombok, modelmapper.

# IDE / Lombok
Foi utilizada a ide intellij no desenvolvimento, se por acaso o teste for ser realizado 
no Eclipse é necessário a configuração do plugin do lombok.
https://projectlombok.org/setup/eclipse

# ITEM
`curl --location --request POST 'http://localhost:8080/api/items' \
--header 'Content-Type: application/json' \
--data-raw '{
"description": "Banana",
"value":"2.5",
"type": "P"
'}`

`curl --location --request GET 'http://localhost:8080/api/items/08fb3191-33d1-455e-a4e6-d75587ed80ac'`

`curl --location --request PUT 'http://localhost:8080/api/items/08fb3191-33d1-455e-a4e6-d75587ed80ac' \
--header 'Content-Type: application/json' \
--data-raw '{
"description": "Apartamento",
"value":"6.0",
"type": "P"
}'`

`curl --location --request DELETE 'http://localhost:8080/api/items/08fb3191-33d1-455e-a4e6-d75587ed80ac'`

`curl --location --request DELETE 'http://localhost:8080/api/items/08fb3191-33d1-455e-a4e6-d75587ed80ac'`

# ORDER

`curl --location --request POST 'http://localhost:8080/api/orders' \
--header 'Content-Type: application/json' \
--data-raw '{
"number": 12,
"date": "22-07-2022 00:00:00",
"percentualDiscount": "20.0"
}'`

`curl --location --request GET 'http://localhost:8080/api/orders/55198417-a9a4-4e22-8ba0-2c12de83caf5'`

`curl --location --request PUT 'http://localhost:8080/api/orders/e1d32d8d-fc2c-4dfd-8f1b-8da7722b7a46' \
--header 'Content-Type: application/json' \
--data-raw '{
"number": 12,
"date": "22-07-2022 00:00:00",
"percentualDiscount": "20.0",
"totalValue": "12.1"
}'`

`curl --location --request DELETE 'http://localhost:8080/api/orders/e1d32d8d-fc2c-4dfd-8f1b-8da7722b7a46' \
--data-raw ''`

`curl --location --request GET 'http://localhost:8080/api/orders/' \
--data-raw ''`

# OrderItems

`curl --location --request POST 'http://localhost:8080/api/orders/2dcf2f53-a08e-4aec-9b3e-8fb564481fa2/items/' \
--header 'Content-Type: application/json' \
--data-raw '{
"itemId": "717c7abd-d6b1-4580-829b-fdcada2118eb",
"quantity": 21.0    
}'`

`curl --location --request GET 'http://localhost:8080/api/orders/2dcf2f53-a08e-4aec-9b3e-8fb564481fa2/items/717c7abd-d6b1-4580-829b-fdcada2118eb'`

`curl --location --request PUT 'http://localhost:8080/api/orders/b7a46382-3c8e-4804-9e8b-05b1f5584ac1/items/50c4b0e7-f532-4a35-a73b-21fbd7d6145e' \
--header 'Content-Type: application/json' \
--data-raw '{
"itemId":"50c4b0e7-f532-4a35-a73b-21fbd7d6145e",
"quantity": "12"
}'`

`curl --location --request DELETE 'http://localhost:8080/api/orders/61648b32-a027-43d7-8bb0-96434472efa4' \
--data-raw ''`

`curl --location --request GET 'http://localhost:8080/api/orders/' \
--data-raw ''`

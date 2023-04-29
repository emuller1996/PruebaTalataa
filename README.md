
# Prueba Talataa

Esta aplicacion esta desarollado con el fin de presentarla como respuesta para un prueba tecnica.
Una aplicacion muy sencilla,cuenta con su login y registro. los dentro del sistema podra ver los asteroides cercanos a la tierra.


## Tecnologia Utilizadas

- Java. 
- AndriodStudio.
- SQLite3.
-  Retrofit (HTTP).


## API Utilizadas.

Se utilizo la api publica de la NASA. (NEO) 

https://api.nasa.gov/neo/rest/v1/feed?start_date=2015-09-07&end_date=2015-09-08&api_key=DEMO_KEY

#### Get all Asteroides

```http
  GET /neo/rest/v1/feed
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `api_key` | `string` | **DEFAUL**. "KEY_DEMO" |
| `start_date=` | `string` | **DEFAUL**. "2023-04-27" |



MY API: 

http://15.228.232.99:3000/

Es una api desarolladora por mi para un sistema de facturacion pequeño, decidi implementar un end de ese api, CATEGORIAS que se utiza para gestionar la informacion de la categorais de un producto.

#### Get all Categorias
 
 ```http
  GET /categorias
```

#### Get Categoria by Id
 
 ```http
  GET /categorias/{id}
```

#### Create Categoria
 
 ```http
  POST /categorias/
```

#### Update Categoria
 
 ```http
  PUT /categorias/{id}
```




## Screenshots

### Login

<img src="https://user-images.githubusercontent.com/40220427/234968502-c20194bb-5e96-4ac4-9168-f777ca9c46f7.jpg" width="200">

### Registrame

<!-- 
![Screenshot_20230427_135549_PruebaTalataa](https://user-images.githubusercontent.com/40220427/234968548-4a1ee97b-fd84-4af1-b07b-69f3802c400a.jpg)
-->

<img src="https://user-images.githubusercontent.com/40220427/234968548-4a1ee97b-fd84-4af1-b07b-69f3802c400a.jpg" width="200">

### Lista Asteroides
<!-- 
![Screenshot_20230427_135722_PruebaTalataa](https://user-images.githubusercontent.com/40220427/234968616-4ca6bf8c-90a3-4bf7-a311-a2e41a0f03bc.jpg)
-->

<img src="https://user-images.githubusercontent.com/40220427/234968616-4ca6bf8c-90a3-4bf7-a311-a2e41a0f03bc.jpg" width="200">


### Detalle Asteroide 
<!-- 
![Screenshot_20230427_135730_PruebaTalataa](https://user-images.githubusercontent.com/40220427/234968624-c5e2bdd0-6af1-4aa1-825d-7bd6a84eb8bd.jpg | width=100)
-->


<img src="https://user-images.githubusercontent.com/40220427/234968624-c5e2bdd0-6af1-4aa1-825d-7bd6a84eb8bd.jpg" width="200">



### Gestion Categorias++ 

Como plus realize una CRU  para gestionar informacion de las categorias de la API antes mencionada.

<img src="https://user-images.githubusercontent.com/40220427/235322576-9e4924e3-af51-4b51-b3e8-c6621f1528cd.jpg" width="200">
<img src="https://user-images.githubusercontent.com/40220427/235322579-957999ee-9e40-47b5-b057-0accfd2b2910.jpg" width="200">
<img src="https://user-images.githubusercontent.com/40220427/235322582-1f92a8f4-d4f1-4f64-8d12-d392d61ef5d0.jpg" width="200">


<!--

![Screenshot_20230429_151437_PruebaTalataa](https://user-images.githubusercontent.com/40220427/235322576-9e4924e3-af51-4b51-b3e8-c6621f1528cd.jpg)
![Screenshot_20230429_151443_PruebaTalataa](https://user-images.githubusercontent.com/40220427/235322579-957999ee-9e40-47b5-b057-0accfd2b2910.jpg)
![Screenshot_20230429_151448_PruebaTalataa](https://user-images.githubusercontent.com/40220427/235322582-1f92a8f4-d4f1-4f64-8d12-d392d61ef5d0.jpg)
-->



## REACT++

Como plus he desarollado una aplicacion muy pequeña con react para poder destacar mas en mi postulacion y demostrar mi habilidades.(Me enteré que estan migrando a REACT)

### LINKS 

- Deploy :  http://prueba-talataa-muller.s3-website-sa-east-1.amazonaws.com/
- Repo :  https://github.com/emuller1996/prueba-talataa-react-plus

### Tecnologias o Librerias Utilizadas
    - Axios ("https://axios-http.com/docs/intro")
    - ReactPaginate ("https://www.npmjs.com/package/react-paginate")
    - React Datepikeer ("https://reactdatepicker.com/")



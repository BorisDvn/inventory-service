# GraphQL Web Services in Spring Boot

        mvn spring-boot:run


### h2- Database
http://localhost:8091/h2-console  
jdbc:h2:mem:products-db

### graphiql
http://localhost:8091/graphiql

*
<code>
mutation ($id: String, $n: String, $p: Float, $q: Int, $catId: Float) {
updateProduct(id: $id, product: {name: $n, price: $p, quantity: $q, categoryId: $catId}) {
name
quantity
price
}
}
</code>

*
<code>
{"id": "bb302257-72b5-4d13-b21c-856f36205786", "n": "testtt", "p":12345, "q":0, "catId":2}
</code>

*
<code>
{ productList { id, name, category { id } } }
</code>

*
<code>
{ productById(id: "aa59011d-b146-4447-86d5-1276ba7a97bf") {
name, price, category { name, products { name } } } }
</code>

 * 
<code>
mutation { updateProduct(id: "9f9f3469-55c2-4b3f-8434-0f90e3555077"
product: {name: "ee111", price: 456000, quantity: 40000, categoryId: 1})
{ name, quantity, price } }
</code>
  
*
<code>
mutation { saveProduct(product: {name: "ee", price: 456, quantity: 4, categoryId: 1}) {
id, name, price, quantity, category { name } } }
</code>
  
*
<code>
mutation { deleteProduct(id: "9f9f3469-55c2-4b3f-8434-0f90e3555077")}
</code>


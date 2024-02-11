# Desafio
## Deverá ser criada uma aplicação de gerenciamento de uma biblioteca para locação dos livros de uma escola. A escola não cobra aluguel nem multa por dia de atraso. Tendo em vista uma API de MVP ( Mínimo Produto Viável ), a API deve conter as entidades mínimas de Livro, Autor, Locatario e Aluguel seguindo as regras de relacionamento abaixo:<br>




* Cada autor poderá ter 0 ou mais livros
* Cada livro deverá ter 1 ou mais autores
* Aluguel deverá ser de no mínimo 1 ou vários livros
* Cada Aluguel deverá ter um Locatario
<br>


## Diretrizes


* Deverá expor uma API REST de cadastro, alteração, remoção e consulta de autores, livros, locatários e um gerenciamento de aluguéis de livros


* É importante que os dados sejam persistidos e que não sejam perdidos com o restart da aplicação


* Para fins de exercício, a segurança das interfaces pode ser abstraída e qualquer chamada para as interfaces pode ser considerada como autorizada. A solução deve ser construída em java, usando Spring-boot, mas os frameworks e bibliotecas são de livre escolha (desde que não infrinjam direitos de uso).


* O foco dessa avaliação é a comunicação com o backend. Essa comunicação é feita através de mensagens no formato JSON, onde essas mensagens serão interpretadas pelo cliente para montar as telas onde o usuário vai interagir com o sistema
 
*  A aplicação cliente não faz parte da avaliação, apenas os componentes do servidor


### Autor


* Nome - obrigatório
* Sexo - opcional
* Ano de nascimento - obrigatório
* CPF - obrigatório e único
 
## Locatario


* Nome - obrigatório
* Sexo - Opcional
* Telefone - Obrigatório
* E-mail - obrigatório e único
* Data de nascimento(Dia-Mês-Ano) - obrigatório
* CPF - obrigatório e único


## Livro


* Nome - obrigatório
* ISBN do livro (caso não conheça é um RG dos livros, procurem saber o que é) - obrigatório
* Data de publicação - obrigatória


## Aluguel


* Data retirada
* Data devolução - Por default, deve ser de 2 dias
 
<br>


# A API deve seguir as seguintes instruções


* Criar um manual(README) com as instruções de instalação do projeto.
  * O manual deve conter os processos mínimos necessários para executar a aplicação.
  * O  Manual deve conter breves explicações sobre as implementações feitas.




* Ao menos um exemplo de cada um dos métodos mínimos de um CRUD
  * <code> POST</code>
  * <code> GET</code>
  * <code>DELETE</code>
  * <code> PUT</code>


* Conter ao menos 3 métodos que usem os tipos de entrada de dados
  * <code>@RequestBody</code>
  * <code>@PathVariable</code>
  * <code>@RequestParam</code>
 
* Ser possível Cadastrar um Livro, Autor, Locatario e Aluguel
* Listar quais Livros estão disponíveis para alugar
* Listar livros que estão alugados
* Buscar um Livro pelo ID
* Buscar um Autor pelo nome
* Listar todos os livros que foram alugados por um Locatário
* Deverá ser possível consultar quais Livros são de autoria de um autor pesquisado
* Implementar ao menos um endpoint de deletar em uma das entidade seguindo as regras de exclusão
   * Um Livro só pode ser excluído caso não tenha sido alugado.
   * Um Autor somente pode ser excluído caso não possua livros associados.
   * Um Locatário somente pode ser excluído caso não possua algum livro para devolução.
 
<br>


# Diferenciais:
 
* Swagger
* Deploy
* CI/CD
* Docker


# Tarefa Bônus 1 - Performance


* Imagine que sua aplicação possa ser usada em cenários que existam centenas de milhares de acessos. Ela deve se comportar de maneira performática nesses cenários
 
* Testes de performance são uma boa maneira de garantir e observar como sua aplicação se comporta


# Tarefa Bônus 2 - Consumir uma API externa


* Consumir uma API externa para validar o ISBN ou completar informações dos livros.<br>
Possíveis APIs de consumo:
```
https://www.googleapis.com/books/v1/volumes?q=isbn:{ISBN}
```
```
https://openlibrary.org/isbn/{ISBN}.json

```
<br>


# Tarefa Bônus 3 - Versionamento da API
Seu software já deve estar pronto a este ponto e estas implementações devem ser feitas como se fosse uma segunda versão da sua API!


Imagine que agora a Escola irá implementar as cobranças, e você deve implementar:


* Inserir multa de atraso em entregas
  * Locatario tem até as 22h do dia de entrega para finalizar a entrega
  * Após deve ser cobrado R$ 1,00 por dia de atraso
* Cobrança de um valor de Aluguel conforme dias locados
  * Cada dia locado irá custar R$ 2,00


Obs: Explique o que você teve de fazer para conseguir inserir essas features?  e crie uma branch exclusiva para essa nova feature e coloque o nome da mesma como:  <code>feature/v2</code>
<br>


# O que será avaliado:
* Simplicidade no design da solução (evitar over engineering)
* Organização do código
* Arquitetura do projeto
* Boas práticas de programação (manutenibilidade, escalabilidade, legibilidade etc)
* Possíveis bugs
* Tratamento de erros e exceções
* Explicação breve do porquê das escolhas tomadas durante o desenvolvimento da solução
* Uso de testes automatizados e ferramentas de qualidade
* Limpeza do código
* Documentação do código e da API
* Logs da aplicação
* Mensagens e organização dos commits

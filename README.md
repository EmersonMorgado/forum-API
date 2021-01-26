# Forum-API REST

API Rest de forum com Spring Boot.

Caracteríticas da API
- Banco em memória H2 para ambientes de desenvolvimento e testes automatizados
- MySQL para ambiente de produção
- Paginação e ordenação com Spring Data JPA
- Utilização do módulo de cache do Spring Boot
- Spring Security para autenticação e autorização de acessos por sessao (commites iniciais)
- Autenticação stateless utilizando tokens JWT (Json Web Token)
- Tratativa nas mensagens de erro com @RestControllerAdvice e @ResponseStatus
- LocaleContextHolder para envio das mensagens de validação no idioma solicitado
- Sistema de validação com Bean Validation e personalizar o JSON, que será devolvido ao cliente da API
- @Transactional para controlle de commits na transação do JPA apenas do no final do método.
- Monitoramento da API com Spring Boot Actuator 
- Documentação da API Rest, utilizando o Swagger, com o módulo SpringFox Swagger
- Utilização de profiles com configurações específicas para dev, test e prod.
- Implementação de exemplos de testes automatizados de classes que são beans do Spring, como Controllers e Repositories


Outras testes realizados:
- Deploy da aplicação com os arquivos do tipo .jar w .war
- Utilização de variáveis de ambiente para perfil de produção
- Deploy utilizando Docker e docker-composer 

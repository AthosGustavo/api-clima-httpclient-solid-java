# Consumindo a Api do clima utilizando a classe HttpClient. 
Fiz esse projeto em java utilizando a API do clima para treinar as boas práticas do solid.
Sendo assim, de forma proposital não segui as boas práticas na primeira versão desse projeto (Solid_v1) e ao longo das refatorações sigo corrigindo os problemas estruturais do código.

## Comentários e atualizações de cada versão refatorada.

### Solid_v1
 - Os atributos chave,regiao e apiUrl são declarados no método main
 - Todas as funcionalidades estão sendo executadas de maneira corrida no método main dentro da classe Main
 - O método main faz a conexao com HttpClient e processar a resposta, formata e listar os dados.

### Solid_v2
 - Os atributos chave,regiao e apiUrl são declarados no método main.
 - Métodos foram criados para evitar o ´codigo corrido´.
 - O metodo disparaGet recebe o link da api como parâmetro, faz a requisição e devolve a response.
 - O método exibeInfoClima, em seu parametro, recebe a variavel que recebe a response e detro do metodo converte o valor para JSONObject.

### Solid_v3
 - Os atributos chave,regiao e apiUrl são declarados no método main.
 - Os métodos disparaGet e exibeInfoClima são declarados dentro da classe ClimaService.
 - A classe ClimaService possui duas responsabilidades:fazer a conexão e listar os dados.

### Solid_v4
 - Os atributos chave,regiao e apiUrl são declarados no método main.
 - Ao invés do método disparaGet ser chamado no método main,agora ele é chamado dentro de ClimaService,retorna a response e lá mesmo é tratada.
 - Através do parâmetro de ClimaService é passado o link da api e consequentemente também é passada dentro do parâmetro de disparaGet que é chamada dentro de ClimaService.
 - A chave,regiao e apiUrl ainda são declaradas no método main.

### Solid_v5
 - Os atributos chave,regiao e apiUrl são declarados no método main.
 - A chave,regiao e apiUrl ainda são declaradas no método main
   Caso ouvesse mais de um metodo HTTP na classe Client,seria necessário instanciar a classe HttpClient para todos os casos.
   Pensando nisso, criei um atributo do tipo HttpClient na classe Client,fiz um método construtor que recebe no parâmetro
   Um valor do tipo HttpClient e atribui esse valor aou atributo da classe.
 - Na classe ClimaService,dentro do método exibeInfoClima a classe HttpClient é instanciada e sua variável é passada dentro
   do método construtor da instância da Classe Client.
 - Resumo:Caso houver um método POST ou DELETE, não será necessário instanciar a classe HttpClient várias vezs.

### Solid_v6 (Versão final)
 - Criação da classe Clima e remoção da declaração dos atributos no método main.
 - Interação com o usuario adicionada através do console.
   








        

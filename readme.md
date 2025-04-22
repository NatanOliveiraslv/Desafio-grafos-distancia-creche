```markdown
# Gerenciador de Conexões de Creches

Este projeto é uma aplicação baseada em Java projetada para gerenciar e analisar conexões entre creches. Ele fornece funcionalidades para listar creches, registrar conexões, calcular distâncias e exibir matrizes de conexões.

## Recursos

- **Listar Conexões**: Visualizar todas as conexões entre creches.
- **Buscar Conexões**: Pesquisar conexões de uma creche específica, ordenadas por distância.
- **Registrar Nova Conexão**: Adicionar uma nova conexão entre duas creches com uma distância especificada.
- **Listar Creches Cadastradas**: Exibir todas as creches cadastradas no sistema.
- **Distância Entre Duas Creches**: Calcular e exibir a distância entre duas creches específicas.
- **Imprimir Matriz de Conexões**: Exibir a matriz de adjacências que representa as conexões entre as creches.

## Estrutura do Projeto

- `src/Main.java`: Ponto de entrada da aplicação. Gerencia a interação do usuário e a navegação pelos menus.

- `src/ManipulaDados.java`: Classe principal para gerenciamento de dados, incluindo leitura e gravação no arquivo, além de manipular operações de creche e conexão.
- `src/ListaEncadeadaDistanciaCreche.java`: Implementa uma lista encadeada para gerenciar conexões entre creches.
- `src/ListaEncadeadaCreche.java`: Implementa uma lista encadeada para gerenciar creches.
- `src/estrutura.txt`: Arquivo de entrada contendo a lista de creches e suas conexões.

## Formato do Arquivo de Entrada (`estrutura.txt`)

1. **Creches**: Listadas linha por linha no início do arquivo.
2. **Conexões**: Representadas como `id1,id2,distância` onde:
- `id1` e `id2` são os IDs das creches conectadas.
- `distância` é a distância entre elas em quilômetros.

### Exemplo:
```
PedroFernandes
HerculanoDeMelo
FranciscoPauloDeOliveira

0,1,14.5
0,2,3.6
2,3,14.7
```

## Como Executar

1. Clone o repositório e abra-o na sua IDE preferida (por exemplo, IntelliJ IDEA).
2. Certifique-se de que o arquivo `estrutura.txt` esteja localizado no diretório `src`.
3. Compile e execute o arquivo `Main.java`.
4. Use o menu para interagir com a aplicação.

## Dependências

- Java 8 ou superior.

## Uso

1. **Listar Conexões**: Exibe todas as conexões e suas respectivas distâncias.
2. **Pesquisar Conexões**: Insira o nome de uma creche para visualizar suas conexões.
3. **Cadastrar Nova Conexão**: Informe os nomes de duas creches e a distância entre elas para cadastrar uma nova conexão.
4. **Listar Creches**: Exibe todas as creches cadastradas.
5. **Distância Entre Duas Creches**: Insira os nomes de duas creches para calcular a distância entre elas.
6. **Imprimir Matriz**: Exibe a matriz de adjacência das conexões.

## Exemplo de Saída

```
------------------------------------
| 1 - Listar conexões |
| 2 - Buscar conexões de creche |
| 3 - Cadastrar nova conexão |
| 4 - Listar Creches cadastradas |
| 5 - Distância entre duas creches |
| 6 - Imprimir Matriz |
| 0 - Sair |
------------------------------------

Digite a opção desejada: 2
Digite o nome da creche: Pedro Fernandes
Conexões da creche 'PedroFernandes' (ordenadas por distância):

-> HerculanoDeMelo - Distância: 3,6 km
-> FranciscoPauloDeOliveira - Distância: 14,5 km
```

## Contribuindo

Sinta-se à vontade para fazer um fork deste repositório e enviar solicitações pull para melhorias ou correções de bugs.

## Licença

Este projeto está licenciado sob a licença MIT.
```
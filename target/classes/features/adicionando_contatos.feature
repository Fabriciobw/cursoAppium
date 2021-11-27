#language: pt

Funcionalidade: Adicionando contatos a lista, editando e excluindo

Cenario: Adicionando um contato a lista de contatos
	Dado nome, sobrenome e numero
	| nome | sobrenome | numero |
	| Pedro | Henrique | +557199998888 |
	| Luana | Santos   | +557199998383 |
	| Marcos | Augusto | +557199233333 |

	Quando sao preenchidos e salvos
	Entao devem aparecer na lista de contatos
	
Esquema do Cenário: Editando um contato da lista de contatos
	Dado o contato "<nome>" "<sobrenome>" para ser editado
	Quando os dados "<nomeEditado>" "<sobrenomeEditado>" e "<numeroEditado>" são adicionados
	Entao o registro deve ser editado contendo "<nomeEditado>" "<sobrenomeEditado>" e "<numeroEditado>"
	
	Exemplos:
    | nome     | sobrenome  | nomeEditado |  sobrenomeEditado | numeroEditado  |
    |  Pedro   |  Henrique  |  Fabricio   |    Silva         |  +55717777-7777 |
    
 Cenario: Removendo um contato da lista
	Dado um contato da lista com "<nome>" "<sobrenome>"
	Quando o contato "<nome>" é pressionado e deletado
	Entao "<nome>" "<sobrenome>" não deve aparecer mais na lista de contatos
	
	Exemplos:
	| nome     | sobrenome | 
	| Fabricio | Silva     | 
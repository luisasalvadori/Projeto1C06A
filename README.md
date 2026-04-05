**Luísa de Medeiros Salvadori - GEC 2142**

**Utilização de IA:**
Foi utilizado o ChatGPT (GPT-5.3 OpenAI) para sanar algumas dúvidas

---

 **Prompt 1**

<ins>Pergunta:</ins>  
"Seguindo as orientações do pdf, gostaria de entender como fazer a classe ProcessarPedido e porque eu devo fazer uma classe separada para dizer só uma mensagem. Me explique como funciona."

<ins>Resposta:</ins>  
Classe ProcessarPedido: finalidade e justificativa  
A criação da classe ProcessarPedido atende a um dos princípios fundamentais da Programação Orientada a Objetos: o princípio da responsabilidade única (Single Responsibility Principle). Esse princípio estabelece que cada classe deve possuir uma única responsabilidade dentro do sistema.  

No contexto do exercício proposto, o sistema envolve diferentes entidades com papéis bem definidos:  
A classe Cliente é responsável por armazenar informações do cliente e os computadores adquiridos.  
A classe Computador representa os produtos disponíveis para compra.  
A classe principal (ou sistema) gerencia o fluxo da aplicação.  
Nesse cenário, a classe ProcessarPedido é responsável exclusivamente por representar a etapa de finalização do pedido.  

Por que criar uma classe separada?  
Embora o método solicitado tenha uma implementação simples (apenas exibir a mensagem "Pedido enviado..."), a separação em uma classe própria traz vantagens importantes:  

- Organização do código  
Evita que classes como Cliente ou Loja acumulem responsabilidades que não lhes pertencem.  

- Manutenibilidade  
Caso o processamento do pedido se torne mais complexo no futuro (por exemplo, salvar em banco de dados, enviar confirmação, atualizar estoque), essas alterações ficarão centralizadas em um único local.  

- Reutilização  
A funcionalidade pode ser reutilizada em diferentes partes do sistema sem duplicação de código.  

- Clareza estrutural  
O sistema passa a refletir melhor as etapas reais de um processo de compra.  

Implementação da classe  
A classe ProcessarPedido deve conter um método utilitário (helper), que pode ser definido como estático, já que não depende do estado de um objeto específico.  

Exemplo de implementação:

```java
public class ProcessarPedido {

    public static void processar(Computador[] computadores) {
        System.out.println("Pedido enviado...");
    }
}
```

Uso no sistema  

`ProcessarPedido.processar(cliente.getComputadores());`

Conclusão  
A criação da classe ProcessarPedido, mesmo para uma funcionalidade simples, é uma decisão de projeto que segue boas práticas de orientação a objetos. Ela contribui para a organização, clareza e escalabilidade do sistema, permitindo que cada classe desempenhe um papel bem definido dentro da aplicação.

---

**Prompt 2**

<ins>Pergunta:</ins>  
No UML do projeto temos apenas cinco classes, além da Main, mas quando fui instanciar cada computador na Main, ficaram muitas informações bagunçadas. Seria interessante criar outra classe para fazer a instanciação dos computadores e também organizar os preços ou não pode?

<ins>Resposta:</ins>  
Sim, criar uma nova classe para organizar a instanciação dos computadores e os preços é uma boa decisão de projeto, especialmente do ponto de vista de boas práticas em Programação Orientada a Objetos.

Justificativa  

A Main deve, preferencialmente, ter a responsabilidade de controlar o fluxo do programa, e não concentrar lógica de criação de objetos complexos. Quando muitas informações ficam diretamente na Main, o código tende a se tornar:

- Difícil de ler  
- Difícil de manter  
- Pouco reutilizável  

Ao criar uma classe específica para instanciar os computadores, você está aplicando o princípio da separação de responsabilidades, tornando o sistema mais organizado.

Vantagens dessa abordagem  

- Melhor organização do código  
A lógica de criação dos computadores fica centralizada em um único lugar.  

- Facilidade de manutenção  
Caso seja necessário alterar configurações (hardware, preços, etc.), a modificação será feita em apenas uma classe.  

- Reutilização de código  
A criação dos computadores pode ser utilizada em outras partes do sistema, sem duplicação.  

- Maior clareza na Main  
A Main fica mais limpa, focando apenas na interação com o usuário e no fluxo da aplicação.  

Exemplo de implementação  

```java
public class ComputadorBuilder {

    public static Computador criarPC1(int matricula) {
        Computador pc = new Computador("Apple", matricula);
        return pc;
    }

    public static Computador criarPC2(int matricula) {
        Computador pc = new Computador("Samsung", matricula + 1234);
        return pc;
    }

    public static Computador criarPC3(int matricula) {
        Computador pc = new Computador("Dell", matricula + 5678);
        return pc;
    }
}
```

E na Main:

```java
Computador pc1 = ComputadorBuilder.criarPC1(matricula);
```

Conclusão  

Criar uma classe auxiliar para instanciar os computadores é uma solução adequada e alinhada com boas práticas de desenvolvimento, pois melhora a organização, a legibilidade e a manutenção do código, além de manter a Main mais simples e objetiva.

---

**Prompt 3**

<ins>Pergunta:</ins>  
Para criar essa nova classe Loja, eu devo criar um construtor e chamar a outra classe Computador ou deve ser de outra maneira? Me explique como fazer e porque.

<ins>Resposta:</ins>  
Sim — no seu caso, faz sentido utilizar um construtor na classe Loja e instanciar objetos da classe Computador dentro dele.

Como fazer  

A ideia é que a classe Loja seja responsável por inicializar os computadores disponíveis para venda no momento em que o objeto for criado.

Estrutura geral:

```java
public class Loja {

    private Computador[] comps = new Computador[3];

    public Loja() {

        Computador pc1 = new Computador("Apple", preco1);
        comps[0] = pc1;

        Computador pc2 = new Computador("Samsung", preco2);
        comps[1] = pc2;

        Computador pc3 = new Computador("Dell", preco3);
        comps[2] = pc3;
    }

    public Computador[] getComps() {
        return comps;
    }
}
```

Por que usar construtor nesse caso?  

O uso do construtor é adequado porque a classe Loja possui estado próprio, ou seja:

- ela contém um conjunto de computadores (comps)  
- esses computadores precisam estar prontos assim que a loja for criada  

Assim, o construtor garante que sempre que um objeto Loja for instanciado, ele já estará completamente inicializado, com seus computadores configurados.

Por que instanciar Computador dentro da Loja?  

Isso ocorre porque existe uma relação lógica entre as classes:

- Computador representa um produto individual  
- Loja representa o conjunto de produtos disponíveis  

Portanto, é responsabilidade da Loja criar e organizar os computadores que ela oferece.

Vantagens dessa abordagem  

1. Organização  
A lógica de criação dos computadores fica centralizada na classe Loja, evitando código excessivo na Main.  

2. Encapsulamento  
A Main não precisa saber como os computadores são montados, apenas acessá-los:  

```java
Loja loja = new Loja();
Computador[] pcs = loja.getComps();
```

3. Coerência com POO  
Cada classe tem uma responsabilidade bem definida:  

Computador → representa o objeto  
Loja → gerencia os computadores disponíveis  

4. Inicialização automática  
O construtor garante que o objeto já nasce pronto para uso, sem necessidade de chamadas adicionais.

Conclusão  

Neste contexto, a melhor abordagem é:

- Utilizar um construtor na classe Loja  
- Instanciar objetos da classe Computador dentro desse construtor  
- Armazená-los em um array da própria classe  

Essa solução é adequada, organizada e alinhada com os princípios da Programação Orientada a Objetos.

---

**Prompt 4**

<ins>Pergunta:</ins>  
Tenho uma última dúvida, gostaria de colocar o preço individual de cada computador no momento de mostrar as configurações (onde está o método mostraPCConfigs). Como o preço depende da marca, eu devo fazer uma estrutura de if-else ou switch dentro desse método para identificar o preço?

<ins>Resposta:</ins>  
Não é recomendado usar if-else ou switch dentro do método mostraPCConfigs para determinar o preço com base na marca.

Por quê?  

Porque isso violaria um princípio importante da Programação Orientada a Objetos: encapsulamento.

A classe Computador já possui o atributo preço. Logo, o valor do preço deve ser:

- definido no momento da criação do objeto  
- armazenado dentro do próprio objeto  
- apenas exibido quando necessário  

Se você usar if-else ou switch baseado na marca, estará:

- duplicando lógica que já foi definida antes  
- tornando o código menos flexível  
- criando dependência entre “marca” e “preço” dentro de um método que deveria apenas exibir informações  

Forma correta  

O preço já foi definido quando você criou o objeto:

```java
Computador pc1 = new Computador("Apple", preco1);
```

Portanto, dentro do método mostraPCConfigs, você deve apenas exibir o preço armazenado.

Exemplo de implementação  

```java
public void mostraPCConfigs() {
    System.out.println("Marca: " + marca);
    System.out.println("Preço: R$" + preco);

    // mostrar hardware
    for (int i = 0; i < hardwares.length; i++) {
        System.out.println(hardwares[i].getNome() + " - " + hardwares[i].getCapacidade());
    }

    // mostrar sistema operacional
    System.out.println("Sistema Operacional: " + sistOp.getNome());

    // mostrar USB
    System.out.println("Acompanha: " + musb.getNome());
}
```

O que NÃO fazer  

```java
if (marca.equals("Apple")) {
    preco = matricula;
} else if (marca.equals("Samsung")) {
    preco = matricula + 1234;
}
```

Esse tipo de lógica está no lugar errado.

Onde o preço deve ser definido?  

No momento da criação do objeto (como você já fez na classe Loja):

```java
Computador pc1 = new Computador("Apple", preco1);
```

Ideia principal  

- Computador sabe seu preço  
- mostraPCConfigs só exibe informações  
- lógica de cálculo de preço fica fora do método de exibição  

Conclusão  

Não utilize if-else ou switch para definir o preço no método de exibição.  
O preço deve ser definido no momento da criação do objeto e apenas exibido posteriormente, garantindo um código mais organizado, coerente e alinhado com os princípios da orientação a objetos.

---

**Prompt 5**

<ins>Pergunta:</ins>  
Estou fazendo na classe `Computador` um setter para adicionar um `HardwareBasico` no array de `HardwareBasico`. Fiz esse código, mas está dando erro, qual é o problema?

```java
public void setHardBasicos(HardwareBasico hb) {
    for(int i=0; i< hardBasicos.length; i++){
        if(hardBasicos[i] == null) {
            hardBasicos[i] = hb;
```

<ins>Resposta:</ins>  

O problema do seu código não está na lógica principal, mas sim em detalhes de implementação que podem gerar erro de compilação ou comportamento inesperado.

1. Problema mais provável: método incompleto

O código enviado está sem as chaves de fechamento `}`.

O correto seria:

```java
public void setHardBasicos(HardwareBasico hb) {
    for(int i = 0; i < hardBasicos.length; i++) {
        if(hardBasicos[i] == null) {
            hardBasicos[i] = hb;
            break;
        }
    }
}
```

Sem essas chaves, o código não compila corretamente.

2. Falta do `break`

Mesmo depois de inserir o hardware em uma posição vazia, o laço continuaria executando.

Isso pode causar problemas lógicos, por isso o ideal é usar:

```java
break;
```

Assim, o método encerra assim que encontrar a primeira posição livre.

3. Verificar se o array foi inicializado

Outro problema muito comum é declarar o array, mas não inicializá-lo:

```java
private HardwareBasico[] hardBasicos;
```

Se isso acontecer, ao tentar acessar `hardBasicos.length`, o programa poderá gerar `NullPointerException`.

O correto é inicializar o array, por exemplo:

```java
private HardwareBasico[] hardBasicos = new HardwareBasico[3];
```

Forma correta completa

Na classe:

```java
private HardwareBasico[] hardBasicos = new HardwareBasico[3];
```

Método:

```java
public void setHardBasicos(HardwareBasico hb) {
    for(int i = 0; i < hardBasicos.length; i++) {
        if(hardBasicos[i] == null) {
            hardBasicos[i] = hb;
            break;
        }
    }
}
```

Observação importante sobre o nome do método

O nome `setHardBasicos` pode ser confuso, porque métodos `set` normalmente servem para substituir um valor inteiro.

Neste caso, o método está adicionando um item ao array, e não trocando o array completo.

Por isso, um nome mais adequado seria:

```java
addHardwareBasico
```

Conclusão

Os possíveis problemas no seu código são:

- falta de chaves `}` → erro de compilação  
- falta do `break` → erro lógico  
- array não inicializado → `NullPointerException`  
- nome do método pouco adequado à função  

Portanto, a lógica de adicionar o hardware está correta, mas o método precisa estar completo, com o array inicializado e, de preferência, com um nome mais coerente com sua finalidade.

---

**Conclusão**

A utilização da Inteligência Artificial, ao longo do desenvolvimento deste trabalho, mostrou-se bastante satisfatória, especialmente nos momentos em que surgiram dúvidas conceituais e estruturais.
O uso do ChatGPT contribuiu para o esclarecimento de conceitos relacionados à POO, auxiliando na separação de responsabilidades, organização do código e definição adequada das classes.

package com.welyab.teste.programador.springboottestebasico.extra.provaconceitos.web;

import com.welyab.teste.programador.springboottestebasico.extra.provaconceitos.web.alternativas.*;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// ===============================================================================
// OBSERVAÇÂO: esta classe não aplica as melhores práticas na construção de serviços
// REST. A intenção dela é servir como canal interativo lúdico para aplicação de prova.
// ===============================================================================

@RestController
@RequestMapping("prova-conceitos")
public class ProvaConceitosController {

    // ====================================================================================================
    // pergunta de exemplo - já está respondida
    // ====================================================================================================
    @GetMapping(path = "pergunta-exemplo", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Resposta> perguntaExemplo() {
        // o texto da pergunta é encapsulado dentro de uma uma classe
        // você não precisa mexer na pergunta
        Pergunta pergunta = new Pergunta(
                "Quanto é 1 + 2?"
        );

        // cada pergunta possui cinco alternativas de reposta. Apenas uma delas é correta.
        // você não precisa mexer nas alternativas
        Alternativa a = new AlternativaA("1");
        Alternativa b = new AlternativaB("2");
        Alternativa c = new AlternativaC("3");
        Alternativa d = new AlternativaD("4");
        Alternativa e = new AlternativaE("5");

        // Este é o único lugar em cada questão que você precisará mexer. Você não precisa mexer nas alternativas,
        // nem na pergunta. Basta que você ofereça a reposta correta
        // sua resposta deve ser encapsulada dentro da classe Resposta, que rece seu seu construtor
        // a pergunta, e alternativa escolhida como resposta
        Alternativa alternativaEscolhida = c; // vou dar C como reposta
        Resposta resposta = new Resposta(pergunta, alternativaEscolhida);
        return ResponseEntity.ok(resposta);
    }

    // ====================================================================================================
    // Pergunta Nº 1 - Idempotência
    // ====================================================================================================
    @GetMapping(path = "pergunta-idempotencia", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Resposta> idempotencia() {
        // pergunta (você não precisa mexer aqui)
        Pergunta pergunta = new Pergunta(
                "O que é idenpotência no contexto de serviços web em padrão REST?"
        );

        // alternativas de resposta (você não precisa mexer aqui)
        Alternativa a = new AlternativaA(
                "Tem relação com capacidade da aplicação de se ajustar à carga "
                        + "de requisições aplicadas em um determinado momento."
        );

        Alternativa b = new AlternativaB(
                "É uma característica de operações que podem ser aplicadas várais vezes e sempre retornam "
                        + "o mesmo valor, ou não mudam o estado da aplicações em chamadas subsequentes."
        );

        Alternativa c = new AlternativaC(
                "É um algoritmo utilizado para determinar a melhor potência de processador a "
                        + "ser aplicada para cada tipo de requisição."
        );

        Alternativa d = new AlternativaD(
                "É a qualidade da identação do código, que deve dinâmica"
        );

        Alternativa e = new AlternativaE(
                "É a capacidade de uma única aplicação rodando poder servir a múltiplos clientes, "
                        + "sem que um tenha conhecimento de outro. "
                        + "Isso não tem relação com múltiplas requisições."
        );

        // sua resposta
        Alternativa alternativaEscolhida = null; // troque null pela sua reposta: a, b, c, d, e
        Resposta resposta = new Resposta(pergunta, alternativaEscolhida);
        return ResponseEntity.ok(resposta);
    }

    // ====================================================================================================
    // Pergunta Nº 2 - Métodos HTTP
    // ====================================================================================================
    @GetMapping(path = "pergunta-metodos-http", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Resposta> metodosHTTP() {
        // pergunta (você não precisa mexer aqui)
        Pergunta pergunta = new Pergunta(
                "Sobre os métodos disponíveis no HTTP, dentro do contexto de serviços web em padrão REST, "
                        + "é possível afirmar que"
        );

        // alternativas de resposta (você não precisa mexer aqui)
        Alternativa a = new AlternativaA(
                "OPTIONS - permite listar as operações disponiveis sobre um recurso. "
                        + "GET - é utilizado para atualizar recursos dentro do servidor."
        );

        Alternativa b = new AlternativaB(
                "DELETE - permite a remoção de um recurso do servidor e não é idempotente. "
                        + "GET - é utilizado para atualizar recursos dentro do servidor."
        );

        Alternativa c = new AlternativaC(
                "OPTIONS - permite listar as operações disponiveis sobre um recurso. "
                        + "PATCH - utilizado para aplicar modificações parciais em algum recurso."
        );

        Alternativa d = new AlternativaD(
                "GET - é utilizado para solicitar a representação de algum recurso disponível na aplicação"
                        + "POST - permite enviar uma objeto para um recurso disponível no servidor"
        );

        Alternativa e = new AlternativaE(
                "PUT - adequado para trocar um recurso dentro da aplicação. "
                        + "POST - também é uma boa prática utilizar post para trocar as informações de um recurso."
        );

        // sua resposta
        Alternativa alternativaEscolhida = null; // troque null pela sua reposta: a, b, c, d, e
        Resposta resposta = new Resposta(pergunta, alternativaEscolhida);
        return ResponseEntity.ok(resposta);
    }

    // ====================================================================================================
    // Pergunta Nº 3 - Organização de classes em pacotes la linguagem Java
    // ====================================================================================================
    @GetMapping(path = "pergunta-pacotes-java", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Resposta> pacotesJava() {
        // pergunta (você não precisa mexer aqui)
        Pergunta pergunta = new Pergunta(
                "Sobre a palavra reservada 'package' do  Java, é possível afirmar que:"
        );

        // alternativas de resposta (você não precisa mexer aqui)
        Alternativa a = new AlternativaA(
                "É utilizada como comando para compilar as classes e enpacotá-las dentro de um único arquivo."
        );

        Alternativa b = new AlternativaB(
                "A palavra 'package' é um canal de comunicação entre o comando de empacotamento da "
                        + "ferramenta Maven e a aplicação escrita em Java."
        );

        Alternativa c = new AlternativaC(
                "É uma particularidade da linguagem Java. Outras linguagens não utilizam nenhuma forma "
                        + "de agrupamento entre os arquivos. "
        );

        Alternativa d = new AlternativaD(
                "A palavra 'package' pode ser utilizada também como nome de variável na linguagem Java."
        );

        Alternativa e = new AlternativaE(
                "Define um agrupamento de classes relacionadas. Classes que possuam o mesmo 'package' "
                        + " tendem a estarem relacionadas de alguma forma."
        );

        // sua resposta
        Alternativa alternativaEscolhida = null; // troque null pela sua reposta: a, b, c, d, e
        Resposta resposta = new Resposta(pergunta, alternativaEscolhida);
        return ResponseEntity.ok(resposta);
    }

    // ====================================================================================================
    // Pergunta Nº 4 - Sobre multitenant e singletenant
    // ====================================================================================================
    @GetMapping(path = "pergunta-multitenant", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Resposta> tenant() {
        // pergunta (você não precisa mexer aqui)
        Pergunta pergunta = new Pergunta(
                "Qual é a definição básica para sistemas multi tenant e single tenant?"
        );

        // alternativas de resposta (você não precisa mexer aqui)
        Alternativa a = new AlternativaA(
                "Multi tenant - em sistema que funcionam no modelo cliente/servidor, descreve "
                        + "uma categoria de aplicações que capazes de responder a múltiplas requisições "
                        + "de forma concorrent, geralmente utilizando mecanismos de threads. "
                        + "Single tenant - são aplicações projetadas para responder apenas uma única requisição "
                        + "de cada vez, mas de forma bastante rápida, geralmente utilizada em mecanismos de "
                        + "fila que garantem a ordem de chegada e saída das informações. "
        );

        Alternativa b = new AlternativaB(
                "Multi tenant - são aplicações que fazem uso de múltiplos banco de dados. Cada "
                        + "instância do banco de dados pode armazenar uma categoria de informações relevante para "
                        + "a aplicação. Isto é uma forma de otimizar a utilização das tarefas de leitura e escrita. "
                        + "Single tenant - são aplicações que fazem uso de uma única fonte para armazenamento de dados, "
                        + "sendo este responsável por suportar processos de leitura e de escrita simutaneamente."
        );

        Alternativa c = new AlternativaC(
                "Multi tenant - são aplicações que conseguem atuar sobre múltiplos usuários de forma "
                        + "independente. Assim, cada usuário terá uma parte da da aplicação para si, sem que seus "
                        + "dados ou recursos tomem conhecimento da existência de outras entidades coexistindo no "
                        + "mesmo ambiente. "
                        + "Single tenant - são aplicações que conseguem atendenr a único cliente. Se uma instância do "
                        + "sistema de vendas, por exemplo, atende a uma padaria, essa mesma instância não seria "
                        + "capaz de suportar os dados de um loja eletrônicos na mesma instância, no mesmo banco "
                        + "de dados, etc."
        );

        Alternativa d = new AlternativaD(
                "Multi tenant - quando múltiplas aplicações fazem uso de um mesmo banco de dados. Dessa "
                        + "forma, o compartilhamento de informações entre diferente aplicações torna-se muito facilitado, "
                        + "e cada aplicação poderá ter seu próprio schema. "
                        + "Single tenant - quando um banco de dados é utilizado por apenas uma única aplicação. Este "
                        + "mecanismo de organização é ruim, pois os recursos do banco de dados ficam muito tempo "
                        + "ociosos."
        );

        Alternativa e = new AlternativaE(
                "Multi tenant - são aplicações que conseguem atendenr a único cliente. Se uma instância "
                        + "sistema de vendas, por exemplo, atende a uma padaria, essa mesma instância não seria "
                        + "capaz de suportar os dados de um loja eletrônicos na mesma instância, no mesmo banco "
                        + "de dados, etc. "
                        + "Single tenant - são aplicações que conseguem atuar sobre múltiplos usuários de forma "
                        + "independente. Assim, cada usuário terá uma parte da da aplicação para si, sem que seus "
                        + "dados ou recursos tomem conhecimento da existência de outras entidades coexistindo no "
                        + "mesmo ambiente."
        );

        // sua resposta
        Alternativa alternativaEscolhida = null; // troque null pela sua reposta: a, b, c, d, e
        Resposta resposta = new Resposta(pergunta, alternativaEscolhida);
        return ResponseEntity.ok(resposta);
    }

    // ====================================================================================================
    // Pergunta Nº 5 - Códigos de Status do HTTP
    // ====================================================================================================
    @GetMapping(path = "pergunta-http-status", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Resposta> httpStatus() {
        // pergunta (você não precisa mexer aqui)
        Pergunta pergunta = new Pergunta(
                "Uma resposta HTTP leva consigo uma código de status que descreve o sucesso ou falha da operação. "
                        + "Sobre estes códigos, é possível afirmar que:"
        );

        // alternativas de resposta (você não precisa mexer aqui)
        Alternativa a = new AlternativaA(
                "Código 200 (Ok) - Informa que a requisição fio processada com sucesso. "
                        + "Código 301 (Movido permanentemente) - Informa que o recurso solicitado foi movido para um outro local. "
                        + "Código 404 (Não encontrado) - Informa que o recurso solicitado não existe na aplicação. "
        );

        Alternativa b = new AlternativaB(
                "Os códigos que iniciam com 2 (200, 201...) são status de informação, sem indicar erro. "
                        + "Os códigos que iniciam com 3 (300, 301...) são status que indicam erro provocado pelo cliente. "
                        + "Os códigos que iniciam com 5 (500, 501...) indicam erros ocorridos na aplicação. "
        );

        Alternativa c = new AlternativaC(
                "Os códigos de status grupo 5 (500, 501...) devem ser enviados somente quando a própria "
                        + "aplicação apresenta falha, não sendo necessário enviá-los quando o erro acontece no banco "
                        + " de dados, por exemplo."
        );

        Alternativa d = new AlternativaD(
                "O cliente também pode enviar requisições com códigos de status, descrevendo qual é a "
                        + "mensagem esperada para alguma solicitação."
        );

        Alternativa e = new AlternativaE(
                "É comum que qualquer método do HTTP (GET, POST, DELETE) possa utiilzar qualquer código de "
                        + "de status, dependendo do resultado da operação. Sendo assim, é uma boa prática que todos os "
                        + "códigos de status do HTTP estejam disponíveis para todos os métodos."
        );

        // sua resposta
        Alternativa alternativaEscolhida = null; // troque null pela sua reposta: a, b, c, d, e
        Resposta resposta = new Resposta(pergunta, alternativaEscolhida);
        return ResponseEntity.ok(resposta);
    }
}

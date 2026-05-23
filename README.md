```markdown
# 🚗 Sistema de Gerenciamento de Estacionamento (EstacioneParque)

Uma API RESTful desenvolvida em **Java** com **Spring Boot** para o gerenciamento de entrada, saída e cálculo automatizado de tarifas de veículos em um estacionamento. Este projeto foi construído como parte de um desafio de código da **DIO (Digital Innovation One)** com o objetivo de aplicar na prática os **Padrões de Projeto (Design Patterns) do GoF**.

---

## 🛠️ Tecnologias Utilizadas

* **Java 23** (Ambiente Eclipse IDE)
* **Spring Boot 3.x** (Web, DevTools)
* **Maven** (Gerenciador de Dependências)
* **Postman** (Para testes de integração e validação das rotas API)
* **Git & GitHub** (Controle de versão)

---

## 📐 Padrões de Projeto Aplicados (Design Patterns GoF)

O grande diferencial deste projeto é a arquitetura limpa e desacoplada obtida através do uso consciente de três padrões fundamentais:

### 1. 🦚 Singleton (`GerenciadorVagas`)
Garante que exista apenas **uma única instância** global controlando o fluxo e o número de vagas disponíveis no estacionamento. Evita concorrência e inconsistência no total de vagas livres.

### 2. 🏛️ Facade (`EstacionamentoFacade`)
Centraliza e simplifica o acesso às regras complexas do sistema (validação de veículos, controle de vagas e cálculo de preços). O `EstacionamentoController` conversa apenas com a Facade, sem precisar conhecer os detalhes internos do negócio.

### 3. ♟️ Strategy (`CalculoTarifa`, `TarifaCarroStrategy`, `TarifaMotoStrategy`)
Permite alternar dinamicamente o algoritmo de cálculo do valor cobrado com base no tipo do veículo (`CARRO` ou `MOTO`). Se novas regras de cobrança ou novos veículos forem adicionados no futuro, basta criar uma nova classe Strategy sem alterar o código existente (**Princípio Aberto/Fechado do SOLID**).

---

## 🛣️ Rotas da API (EndPoints)

A API possui duas rotas principais mapeadas sob o prefixo `/api/estacionamento`:

### 📥 1. Registrar Entrada
* **Método:** `POST`
* **URL:** `http://localhost:8080/api/estacionamento/entrada`
* **Parâmetros de Query (Params):**
    * `placa`: Texto identificador do veículo (Ex: `ABC-1234`)
    * `tipo`: Enumeração com o tipo do veículo (`CARRO` ou `MOTO`)
* **Resposta de Sucesso (200 OK):** `"Entrada do CARRO com registrada com sucesso de placa: ABC-1234"`

### 📤 2. Registrar Saída
* **Método:** `POST`
* **URL:** `http://localhost:8080/api/estacionamento/saida`
* **Parâmetros de Query (Params):**
    * `placa`: Texto identificador do veículo previamente cadastrado (Ex: `ABC-1234`)
* **Resposta de Sucesso (200 OK):** `"Saída do veículo com sucesso!"`
* **Log no Console do Servidor:** Exibe em tempo real a tarifa calculada pela Strategy com base no tempo de permanência (Ex: `Veículo de placa ABC-1234 saiu. Valor cobrado: R$ 0.66`).

---

## 🚀 Como Executar o Projeto Localmente

1. **Clonar o Repositório:**
   ```bash
   git clone [https://github.com/ailtonjrofficial/DIO-Desafio-Design-Patter-Gof-.git](https://github.com/ailtonjrofficial/DIO-Desafio-Design-Patter-Gof-.git)
# Arquitetura de Microservices com Spring Boot e Apache Kafka

Projeto desenvolvido durante o curso **[Arquitetura de Microservices com Spring Boot e Apache Kafka](https://www.udemy.com/course/spring-boot-kafka/)**, com o objetivo de aplicar conceitos de arquitetura distribuída, comunicação assíncrona e integração entre serviços independentes utilizando o ecossistema Spring.

A aplicação simula um sistema de gestão de vendas, dividido em microservices responsáveis por diferentes domínios de negócio, como produtos, clientes, pedidos, faturamento e logística.

## Objetivos do projeto

- Compreender os fundamentos e princípios da arquitetura de microservices.
- Desenvolver serviços independentes utilizando Spring Boot.
- Implementar comunicação assíncrona e integração orientada a eventos com Apache Kafka.
- Trabalhar com bancos de dados independentes por microservice.
- Aplicar conceitos de Docker para provisionamento de infraestrutura.
- Integrar serviços por meio de eventos e Webhooks.
- Implementar armazenamento de arquivos utilizando MinIO.
- Gerar relatórios dinâmicos com Jasper Reports.

## Arquitetura

O projeto utiliza uma arquitetura baseada em microservices, na qual cada serviço possui responsabilidades específicas e pode operar de maneira independente.

Os principais domínios contemplados são:

| Microservice | Responsabilidade |
|---|---|
| Produtos | Gerenciamento de produtos |
| Clientes | Gerenciamento de clientes |
| Pedidos | Gerenciamento de pedidos |
| Faturamento | Processamento de faturamento |

A comunicação entre os serviços utiliza diferentes estratégias de integração, com destaque para a arquitetura orientada a eventos (*Event-Driven Architecture*), utilizando Apache Kafka.

## Tecnologias e ferramentas

| Tecnologia | Aplicação no projeto |
|---|---|
| Java | Linguagem de programação |
| Spring Boot | Desenvolvimento dos microservices |
| Spring Framework | Injeção de dependências e recursos do ecossistema Spring |
| Apache Kafka | Mensageria e comunicação assíncrona |
| Docker | Containerização e provisionamento de serviços |
| MinIO | Armazenamento de arquivos compatível com Amazon S3 |
| Jasper Reports | Geração de relatórios |
| Webhooks | Integração e comunicação entre sistemas |
| SQL / NoSQL | Persistência de dados independente por serviço |

## Conceitos e práticas aplicados

### Microservices Architecture
Separação da aplicação em serviços independentes, organizados por responsabilidades de negócio, favorecendo autonomia, manutenção e escalabilidade.

### Event-Driven Architecture
Utilização de eventos para desacoplar os serviços e permitir que diferentes componentes reajam a acontecimentos do sistema sem depender de comunicação síncrona direta.

### Apache Kafka
Implementação de publicação e consumo de mensagens, explorando conceitos como:

- Producers e Consumers;
- Topics e Partitions;
- Consumer Groups;
- Comunicação assíncrona;
- Distribuição e processamento de eventos.

### Database per Service
Aplicação do princípio de banco de dados independente por microservice, evitando o compartilhamento direto da camada de persistência entre os serviços.

### Docker
Utilização de containers para executar e gerenciar dependências externas necessárias ao funcionamento da arquitetura.

### Integrações e armazenamento
Implementação de Webhooks para comunicação entre sistemas e utilização do MinIO para armazenamento e gerenciamento de arquivos.

### Geração de relatórios
Integração com Jasper Reports para criação de relatórios dinâmicos a partir dos dados da aplicação.

## 🚀 Executando o projeto

Para executar a aplicação, é necessário ter instalado:

- Java (versão compatível com o projeto);
- Maven;
- Docker e Docker Compose;
- Git.

Clone o repositório:

```bash
git clone <URL_DO_REPOSITORIO>
```

Acesse o diretório:

```bash
cd <NOME_DO_REPOSITORIO>
```

Inicie os serviços de infraestrutura utilizando Docker Compose, conforme a configuração disponibilizada no projeto:

```bash
docker compose up -d
```

Em seguida, configure as variáveis de ambiente e os bancos de dados necessários e execute os microservices individualmente.

> Consulte os arquivos de configuração de cada serviço para identificar portas, credenciais e dependências necessárias.

## 🎓 Aprendizados

Este projeto proporcionou uma experiência prática com conceitos importantes para o desenvolvimento de sistemas distribuídos, especialmente:

- Construção e organização de arquiteturas baseadas em microservices.
- Desenvolvimento de APIs e serviços independentes com Spring Boot.
- Comunicação assíncrona utilizando Apache Kafka.
- Integração entre serviços por meio de eventos.
- Isolamento de dados e persistência independente.
- Provisionamento de infraestrutura com Docker.
- Integração com ferramentas externas de armazenamento e geração de relatórios.

## 📌 Contexto

Projeto desenvolvido para fins educacionais, acompanhando o curso **Arquitetura de Microservices com Spring Boot e Apache Kafka**, com adaptações e implementações realizadas durante o processo de aprendizagem.

---

**Tecnologias principais:** Java • Spring Boot • Apache Kafka • Docker • MinIO

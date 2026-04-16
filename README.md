# 📱 Loja Virtual — Cadastro de Produtos

Aplicativo Android desenvolvido como avaliação do 1º Bimestre da disciplina de Desenvolvimento Mobile — **UniCesumar (5º ADS)**.

> Permite cadastrar produtos de uma loja de eletrônicos e visualizar a listagem com persistência local usando Room Database.

---

## 🎯 Funcionalidades

- ✅ Cadastro de produtos com **Nome**, **Código**, **Preço** e **Quantidade**
- ✅ Validações completas nos campos do formulário
- ✅ Persistência local com **Room Database**
- ✅ Listagem de produtos em **RecyclerView** com cards
- ✅ Navegação entre telas com **Intent**
- ✅ Interface limpa com **Material Design**

---

## 🗂️ Estrutura do Projeto

```
com.example.prova_adler
├── model/
│   └── Product.java           # Entidade Room (tabela do banco)
├── database/
│   ├── ProductDao.java        # Interface com métodos de acesso ao banco
│   └── ProductDatabase.java   # Singleton do banco Room
├── adapter/
│   └── ProductAdapter.java    # Adapter do RecyclerView
├── MainActivity.java          # Tela de cadastro com validações
└── ProductListActivity.java   # Tela de listagem dos produtos
```

---

## 🛠️ Tecnologias Utilizadas

| Tecnologia | Uso |
|---|---|
| Java | Linguagem principal |
| Room Database | Persistência local |
| RecyclerView | Listagem de produtos |
| Material Design | Componentes de UI |
| Intent | Navegação entre telas |
| ConstraintLayout / LinearLayout | Estrutura dos layouts |

---

## ✅ Validações Implementadas

- Nenhum campo pode ser deixado em branco
- O preço deve ser um número positivo com no máximo 2 casas decimais
- A quantidade deve ser um número inteiro positivo

---

## 🏗️ Arquitetura Room Database

```
Product.java         →   @Entity (tabela "products")
ProductDao.java      →   @Dao (insert + getAllProducts)
ProductDatabase.java →   @Database (singleton)
```

---

## 📸 Telas do Aplicativo

| Tela de Cadastro | Tela de Listagem |
|---|---|
| Campos: Nome, Código, Preço, Quantidade | Lista com cards: Nome, Código, Preço |
| Botão Cadastrar + Ver Produtos | Botão Voltar |

---

## ▶️ Como Executar

1. Clone o repositório
2. Abra no **Android Studio**
3. Aguarde o Gradle sincronizar
4. Rode em um emulador ou dispositivo físico com **Android 8.0+**


---

## 👨‍💻 Autor

**Adler** — 5º Semestre ADS — UniCesumar Londrina  
Avaliação 1º Bimestre — Desenvolvimento Mobile

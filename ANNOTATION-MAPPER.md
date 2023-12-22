# MapStruct

[MapStruct](https://mapstruct.org/) é usada para simplificar o processo de mapeamento entre objetos. Ele oferece uma maneira fácil e declarativa de definir como os objetos devem ser mapeados uns para os outros, eliminando a necessidade de escrever manualmente o código de mapeamento tedioso e propenso a erros.

A principal ideia por trás do MapStruct é gerar automaticamente o código de mapeamento com base em configurações e anotações fornecidas pelos desenvolvedores. Isso torna o desenvolvimento mais eficiente e menos sujeito a erros, especialmente em projetos grandes e complexos.

Conceitos-chave associados ao MapStruct:

1. **Anotações:** O MapStruct utiliza anotações Java para marcar classes e métodos que desejamos incluir no processo de mapeamento. Algumas das anotações comuns incluem `@Mapper`, `@Mapping`, e `@Mappings`.

2. **Interface de Mapeamento:** Para criar um mapeador com o MapStruct deve-se definir uma interface de mapeamento. Essa interface contém métodos abstratos que especificam como os campos de origem e destino devem ser mapeados.

3. **Geração de Código:** O MapStruct gera automaticamente o código de implementação do mapeador durante o tempo de compilação. Isso é feito com base nas configurações fornecidas nas anotações e na estrutura da interface de mapeamento.

4. **Suporte a Tipos Complexos:** MapStruct é capaz de lidar com mapeamento de tipos complexos, incluindo mapeamento de listas, mapas e até mesmo tipos aninhados.

Em resumo, o MapStruct é uma ferramenta útil para simplificar e automatizar o processo de mapeamento de objetos em Java, reduzindo a quantidade de código boilerplate que os desenvolvedores precisam escrever manualmente. Ele contribui para um código mais limpo, fácil de entender e menos propenso a erros em relação ao mapeamento manual.

## O que é?

MapStruct é um gerador de código que simplifica bastante a implementação de mapeamentos entre tipos de bean Java com base em uma abordagem de convenção sobre configuração.

O código de mapeamento gerado usa invocações de métodos simples e, portanto, é rápido, de tipo seguro e fácil de entender.

## Por que?

Aplicativos multicamadas geralmente exigem mapeamento entre diferentes modelos de objetos (por exemplo, entidades e DTOs). Escrever esse código de mapeamento é uma tarefa tediosa e sujeita a erros. MapStruct visa simplificar este trabalho, automatizando-o tanto quanto possível.

Em contraste com outras estruturas de mapeamento, MapStruct gera mapeamentos de bean em tempo de compilação, o que garante alto desempenho, permite feedback rápido do desenvolvedor e verificação completa de erros.

## Como?

MapStruct é um processador de anotação que está conectado ao compilador Java e pode ser usado em compilações de linha de comando (Maven, Gradle etc.), bem como em seu IDE preferido.

MapStruct usa padrões sensatos, mas sai do seu caminho quando se trata de configurar ou implementar um comportamento especial.

## Instalação

Fonte: [Documentação instalação  mapstruct](https://mapstruct.org/documentation/installation/)

### Apache Maven

Se estiver usando o Maven para construir seu projeto, adicione o seguinte ao seu pom.xml para usar o MapStruct:

```xml
...
<properties>
    <org.mapstruct.version>1.5.5.Final</org.mapstruct.version>
</properties>
...
<dependencies>
    <dependency>
        <groupId>org.mapstruct</groupId>
        <artifactId>mapstruct</artifactId>
        <version>${org.mapstruct.version}</version>
    </dependency>
</dependencies>
...
<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-compiler-plugin</artifactId>
            <version>3.8.1</version>
            <configuration>
                <source>1.8</source> <!-- depending on your project -->
                <target>1.8</target> <!-- depending on your project -->
                <annotationProcessorPaths>
                    <path>
                        <groupId>org.mapstruct</groupId>
                        <artifactId>mapstruct-processor</artifactId>
                        <version>${org.mapstruct.version}</version>
                    </path>
                    <!-- other annotation processors -->
                </annotationProcessorPaths>
            </configuration>
        </plugin>
    </plugins>
</build>
```

### Gradle
Ao usar uma versão moderna do Gradle (>= 4.6), você adiciona algo como as seguintes linhas ao seu build.gradle:

```gradle
dependencies {
    ...
    implementation 'org.mapstruct:mapstruct:1.5.5.Final'
 
    annotationProcessor 'org.mapstruct:mapstruct-processor:1.5.5.Final'
}
```

## Meu `pom.xml`

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>3.1.6</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>
	<groupId>com.api</groupId>
	<artifactId>spring-mapstruct-demo</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<name>spring-mapstruct-demo</name>
	<description>Spring Boot 3 CRUD API | Mapstruct | Lombok  | Java Bean Mappings</description>
	<properties>
		<java.version>17</java.version>
		<org.mapstruct.version>1.5.5.Final</org.mapstruct.version>
	</properties>
	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>com.mysql</groupId>
			<artifactId>mysql-connector-j</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.mapstruct</groupId>
			<artifactId>mapstruct</artifactId>
			<version>${org.mapstruct.version}</version>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
	</dependencies>

	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
				<configuration>
					<image>
						<builder>paketobuildpacks/builder-jammy-base:latest</builder>
					</image>
					<excludes>
						<exclude>
							<groupId>org.projectlombok</groupId>
							<artifactId>lombok</artifactId>
						</exclude>
					</excludes>
				</configuration>
			</plugin>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-compiler-plugin</artifactId>
				<version>3.8.1</version>
				<configuration>
					<source>1.8</source> <!-- depending on your project -->
					<target>1.8</target> <!-- depending on your project -->
					<annotationProcessorPaths>
						<path>
							<groupId>org.mapstruct</groupId>
							<artifactId>mapstruct-processor</artifactId>
							<version>${org.mapstruct.version}</version>
						</path>
                        <path>
                            <groupId>org.projectlombok</groupId>
                            <artifactId>lombok-mapstruct-binding</artifactId>
                            <version>0.2.0</version>
                        </path>
						<!-- other annotation processors -->
					</annotationProcessorPaths>
				</configuration>
			</plugin>
		</plugins>
	</build>

</project>
```
**OBS.** O MapStruct e o Lombok, por padrão, podem não se dar bem ao usar as anotações `@Getter` e `@Setter` do Lombok para gerar métodos de acesso. Uma solução comum é adicionar a dependência `lombok-mapstruct-binding` e configurar o `annotationProcessorPaths` para que o MapStruct e o Lombok possam colaborar adequadamente.

**Adicionar a dependência do Lombok MapStruct Binding:**

```xml
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok-mapstruct-binding</artifactId>
    <version>0.2.0</version>
    <scope>provided</scope>
</dependency>
```

## Interface `ProductMapper`

Esse script é uma interface de mapeamento do MapStruct, que define como os objetos das classes `Product` e `ProductDto` devem ser convertidos entre si.

```java
package com.api.springmapstructdemo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.api.springmapstructdemo.dto.ProductDto;
import com.api.springmapstructdemo.model.Product;

@Mapper(imports = UUID.class)
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

   @Mapping(source = "product.desc", target = "description", defaultValue = "description") // indica como os campos "desc" e "description" devem ser mapeados.
   @Mapping(target = "itemId", expression = "java(UUID.randomUUID().toString())")
   ProductDto modelToDto(Product product);

   @Mapping(source = "productDto.description", target = "desc", defaultValue = "description")
    Product dtoToModel(ProductDto productDto);

}
```

Analisando o código em detalhes:

1. **Anotação `@Mapper`:**

```java
@Mapper(imports = UUID.class)
```
   - Indica que esta interface é uma interface de mapeamento do MapStruct. O MapStruct usará esta interface para gerar automaticamente a implementação das operações de mapeamento entre `Product` e `ProductDto`.
   - A anotação `@Mapper` é colocada no nível da interface que contém métodos de mapeamento. Ela indica ao MapStruct que essa interface contém a lógica para mapear atributos de um objeto para outro.
   - A anotação `@Mapper(imports = UUID.class)` é uma configuração específica do MapStruct para incluir a importação da classe UUID na implementação gerada pelo MapStruct.
   - `imports = UUID.class`: Esta parte específica indica que a classe `UUID` deve ser importada na implementação gerada. Isso significa que, sempre que a implementação do MapStruct precisar usar a classe `UUID` (por exemplo, ao realizar um mapeamento envolvendo UUID), a implementação gerada incluirá uma declaração de importação para `UUID`.

2. **Declaração da Interface `ProductMapper`:**
   ```java
   public interface ProductMapper {
   ```
    - Declaração da interface `ProductMapper` que contém os métodos de mapeamento entre `Product` e `ProductDto`.

3. **Declaração da Instância `INSTANCE`:**
   ```java
   ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
   ```
    - Declaração de uma instância estática `INSTANCE` da interface `ProductMapper`. Esta instância será usada para obter a implementação gerada pelo MapStruct para realizar os mapeamentos.

4. **Método `modelToDto`:**

```java
@Mapping(source = "product.desc", target = "description", defaultValue = "description")
@Mapping(target = "itemId", expression = "java(UUID.randomUUID().toString())")
ProductDto modelToDto(Product product);
```
   - Define um método de mapeamento chamado `modelToDto` que converte um objeto `Product` para um objeto `ProductDto`.
   - A anotação `@Mapping` indica como os campos devem ser mapeados. Neste caso, o campo `desc` de `product` é mapeado para o campo `description` de `ProductDto`.

   I. **`@Mapping(source = "product.desc", target = "description", defaultValue = "description")`:**
   - Indica um mapeamento específico entre a propriedade `desc` de `Product` e a propriedade `description` de `ProductDto`.

   **Explicando as propriedades utilizadas:**
   - `source:` Indica a propriedade de origem que será usada no mapeamento. No meu caso, productDto.description significa que o valor será retirado da propriedade description do objeto productDto. Ou seja, Indica que o valor deve ser buscado na propriedade `desc` do objeto `Product`. 
   - `target:` Indica a propriedade de destino para a qual o valor será mapeado. No meu caso, desc significa que o valor será atribuído à propriedade desc do objeto de destino. Ou seja, Indica que o valor deve ser atribuído à propriedade `description` do objeto `ProductDto`. 
   - `defaultValue:` Especifica um valor padrão a ser usado caso a propriedade de origem (source) seja nula. Neste exemplo, se productDto.description for nulo, o valor padrão "description" será utilizado.

   II. **`@Mapping(target = "itemId", expression = "java(UUID.randomUUID().toString())")`:**
   - Indica um mapeamento específico para a propriedade `itemId` de `ProductDto`.
   - `target = "itemId"`: Indica que o valor deve ser atribuído à propriedade `itemId` do objeto `ProductDto`.
   - `expression = "java(UUID.randomUUID().toString())"`: Especifica uma expressão Java para calcular o valor da propriedade `itemId`. Neste caso, a expressão gera um novo UUID aleatório usando `UUID.randomUUID().toString()`.

Resumindo, o método `modelToDto` da interface de mapeamento `ProductMapper` realiza o seguinte:

- Mapeia a propriedade `desc` de `Product` para a propriedade `description` de `ProductDto`. Se `desc` for nulo, o valor padrão "description" será utilizado.
- Gera um novo valor para a propriedade `itemId` de `ProductDto` usando um UUID aleatório. Este valor não depende da propriedade `Product.desc` e é gerado independentemente.

5. **Método `dtoToModel`:**
   ```java
   @Mapping(source = "productDto.description", target = "desc")
   Product dtoToModel(ProductDto productDto);
   ```
    - Define um método de mapeamento chamado `dtoToModel` que converte um objeto `ProductDto` de volta para um objeto `Product`.
    - A anotação `@Mapping` indica como os campos devem ser mapeados. Neste caso, o campo `description` de `productDto` é mapeado para o campo `desc` de `Product`.

Essencialmente, essa interface serve como um contrato para o MapStruct gerar automaticamente a implementação dos métodos de mapeamento entre `Product` e `ProductDto`. A instância `INSTANCE` é utilizada para obter a implementação concreta gerada pelo MapStruct, permitindo a execução dos métodos de mapeamento de forma eficiente. As anotações `@Mapping` fornecem informações adicionais sobre como os campos devem ser mapeados, permitindo uma personalização mais fina do processo de mapeamento.

### Mais Detalhes que é bom saber:

1. **Geração de Implementação:**
   Durante o processo de compilação, o MapStruct gera automaticamente a implementação dos métodos de mapeamento declarados na interface marcada com `@Mapper`. Os métodos gerados realizam a cópia dos campos do objeto de origem para o objeto de destino.

2. **Configurações Adicionais:**
   A anotação `@Mapper` suporta várias opções de configuração. Você pode personalizar o comportamento do MapStruct usando atributos como `componentModel`, `uses`, `unmappedTargetPolicy`, entre outros. Essas opções permitem adaptar o comportamento do mapeador de acordo com as necessidades específicas do projeto.

   ```java
   @Mapper(componentModel = "spring", uses = AnotherMapper.class)
   public interface MyMapper {
       TargetObject sourceToTarget(SourceObject source);
   }
   ```

3. **Component Model:**
   O atributo `componentModel` é usado para especificar como a instância do mapeador deve ser gerenciada. Os valores comuns incluem "default" (sem injeção de dependência) e "spring" (para integração com o Spring Framework).

   ```java
   @Mapper(componentModel = "spring")
   public interface MyMapper {
       TargetObject sourceToTarget(SourceObject source);
   }
   ```

A anotação `@Mapper` facilita a criação de mapeadores entre objetos em projetos Java, removendo a necessidade de escrever manualmente a implementação de mapeamento. O MapStruct gera automaticamente o código necessário com base nas interfaces anotadas, proporcionando um desenvolvimento mais eficiente e menos propenso a erros.

## Processo para gerar o Mapper

Depois de adicionar as dependências do Mapper no pom, a próxima etapa é adicionar a anotação `@Mapper` que faz parte parte do framework MapStruct e é usada para marcar interfaces que definem mapeamentos entre objetos. Essa anotação informa ao MapStruct que a interface contém métodos de mapeamento que devem ser implementados automaticamente durante a compilação. Por fim a última etapa é compilar o Apache Maven para que crie automaticamente a implementação do Mapper. Essa implementação será gerada na pasta `target` e terá o mesmo nome da interface `ProductMapper`, porém com o nome `ProductMapperImpl`.

O script abaixo é uma implementação gerada automaticamente pelo MapStruct da interface `ProductMapper`.

## Implementação da Classe `ProductMapperImpl`

O script abaixo é uma implementação gerada automaticamente pelo MapStruct da interface `ProductMapper`.

```java
package com.api.springmapstructdemo.mapper;

import com.api.springmapstructdemo.dto.ProductDto;
import com.api.springmapstructdemo.model.Product;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-20T23:17:48-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
public class ProductMapperImpl implements ProductMapper {

   @Override
   public ProductDto modelToDto(Product product) {
      if ( product == null ) {
         return null;
      }

      ProductDto productDto = new ProductDto();

      if ( product.getDesc() != null ) {
         productDto.setDescription( product.getDesc() );
      }
      else {
         productDto.setDescription( "description" );
      }
      productDto.setId( product.getId() );
      productDto.setName( product.getName() );
      productDto.setQuantity( product.getQuantity() ); // do tipo String
      productDto.setPrice( product.getPrice() );

      productDto.setItemId( UUID.randomUUID().toString() );

      return productDto;
   }

   @Override
   public Product dtoToModel(ProductDto productDto) {
      if ( productDto == null ) {
         return null;
      }

      Product product = new Product();

      product.setDesc( productDto.getDescription() );
      product.setId( productDto.getId() );
      product.setName( productDto.getName() );
      if ( productDto.getQuantity() != null ) {
         product.setQuantity( Integer.parseInt( productDto.getQuantity() ) ); // converte para o tipo Integer
      }
      product.setPrice( productDto.getPrice() );
      product.setItemId( productDto.getItemId() );

      return product;
   }
}
```
Analisando o código em detalhes:

1. **Pacote e Importações:**

```java
   package com.api.springmapstructdemo.mapper;

   import com.api.springmapstructdemo.dto.ProductDto;
   import com.api.springmapstructdemo.model.Product;
   import javax.annotation.processing.Generated;
```
- O script está no pacote `com.api.springmapstructdemo.mapper`.
- Importa as classes `ProductDto` e `Product` necessárias para a execução do mapeamento.
- Importa `Generated` da biblioteca `javax.annotation.processing` para indicar que essa classe foi gerada automaticamente durante o processo de compilação.

2. **Anotação `@Generated`:**

```java
   @Generated(
        value = "org.mapstruct.ap.MappingProcessor",
        date = "2023-12-20T23:17:48-0300",
        comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
```
- Essa anotação indica que a classe foi gerada automaticamente pelo MapStruct durante o processo de compilação.
- Fornece informações sobre a geração, incluindo o processador de anotações utilizado, a data e hora da geração, a versão do MapStruct, o compilador Java usado e o ambiente Java.

3. **Classe `ProductMapperImpl` implementando `ProductMapper`:**
   ```java
   public class ProductMapperImpl implements ProductMapper {
   ```
- A classe `ProductMapperImpl` implementa a interface `ProductMapper`. Essa interface que contém as declarações dos métodos de mapeamento.

4. **Método `modelToDto`:**

```java
@Override
public ProductDto modelToDto(Product product) {
        if ( product == null ) {
        return null;
        }

        ProductDto productDto = new ProductDto();

        if ( product.getDesc() != null ) {
        productDto.setDescription( product.getDesc() );
        }
        else {
        productDto.setDescription( "description" );
        }
        productDto.setId( product.getId() );
        productDto.setName( product.getName() );
        productDto.setQuantity( String.valueOf( product.getQuantity() ) );  // tipo String
        productDto.setPrice( product.getPrice() );

        productDto.setItemId( UUID.randomUUID().toString() );

        return productDto;
}
```
- Este método realiza a conversão de um objeto `Product` para um objeto `ProductDto`.
- Se o objeto `product` for nulo, retorna `null`.
- Caso contrário, cria um novo objeto `ProductDto` e atribui os valores correspondentes do objeto `product`.

5. **Método `dtoToModel`:**

```java
    @Override
    public Product dtoToModel(ProductDto productDto) {
        if ( productDto == null ) {
            return null;
        }

        Product product = new Product();

        product.setDesc( productDto.getDescription() );
        product.setId( productDto.getId() );
        product.setName( productDto.getName() );
        if ( productDto.getQuantity() != null ) {
        product.setQuantity( Integer.parseInt( productDto.getQuantity() ) ); // converte para o tipo Integer
        }
        product.setPrice( productDto.getPrice() );

        return product;
    }
```
- Este método realiza a conversão inversa, convertendo um objeto `ProductDto` de volta para um objeto `Product`.
- Se o objeto `productDto` for nulo, retorna `null`.
- Caso contrário, cria um novo objeto `Product` e atribui os valores correspondentes do objeto `productDto`.

Essa classe é gerada automaticamente pelo MapStruct com base nas anotações e configurações definidas na interface de mapeamento `ProductMapper`, ou seja, ela implementa as operações de mapeamento definidas na interface `ProductMapper`.

# Autor
## Feito por: `Daniel Penelva de Andrade`
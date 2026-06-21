package br.com.meupet.config;

import br.com.meupet.entity.*;
import br.com.meupet.repository.*;
import lombok.RequiredArgsConstructor;
import net.datafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
@Profile("dev")
@RequiredArgsConstructor
public class DataLoader
        implements CommandLineRunner {

    private final Faker faker = new Faker();

    private final AnimalRepository animalRepository;
    private final AdotanteRepository adotanteRepository;
    private final AdocaoRepository adocaoRepository;
    private final VacinacaoRepository vacinacaoRepository;
    private final CastracaoRepository castracaoRepository;
    private final DespesaRepository despesaRepository;


    @Override
    public void run(String... args) {

        List<Animal> animais =
                animalRepository.findAll();

        List<Adotante> adotantes =
                adotanteRepository.findAll();

        /*

        if (animalRepository.count() > 0) {
            return;
        }

        System.out.println(
                "Iniciando carga de dados..."
        );



        for (int i = 0; i < 100; i++) {

            Animal animal = Animal.builder()
                    .nome(
                            faker.dog().name()
                    )
                    .especie(
                            faker.options().option(
                                    "Cachorro",
                                    "Gato"
                            )
                    )
                    .raca(
                            faker.options().option(
                                    "SRD",
                                    "Labrador",
                                    "Poodle",
                                    "Persa",
                                    "Pinscher",
                                    "Golden Retriever",
                                    "Siamês"
                            )
                    )
                    .idade(
                            faker.number()
                                    .numberBetween(1, 15)
                    )
                    .sexo(
                            faker.options().option(
                                    "Macho",
                                    "Fêmea"
                            )
                    )
                    .porte(
                            faker.options().option(
                                    "Pequeno",
                                    "Médio",
                                    "Grande"
                            )
                    )
                    .status(
                            faker.options().option(
                                    StatusAnimal.DISPONIVEL,
                                    StatusAnimal.ADOTADO
                            )
                    )
                    .ativo(
                            faker.bool().bool()
                    )
                    .observacoes(
                            faker.lorem().sentence()
                    )
                    .build();

            animalRepository.save(animal);
        }

        System.out.println(
                "100 animais gerados com sucesso."
        );

        for (int i = 0; i < 50; i++) {

            Adotante adotante = Adotante.builder()
                    .nome(
                            faker.name().fullName()
                    )
                    .telefone(
                            faker.phoneNumber()
                                    .cellPhone()
                    )
                    .email(
                            faker.internet()
                                    .emailAddress()
                    )
                    .cpf(
                            String.format(
                                    "%011d",
                                    faker.number()
                                            .numberBetween(
                                                    100000000,
                                                    999999999
                                            )
                            )
                    )
                    .endereco(
                            faker.address()
                                    .fullAddress()
                    )
                    .observacoes(
                            faker.lorem()
                                    .sentence()
                    )
                    .dataCadastro(
                            LocalDate.now()
                                    .minusDays(
                                            faker.number()
                                                    .numberBetween(
                                                            0,
                                                            365
                                                    )
                                    )
                    )
                    .ativo(true)
                    .build();

            adotanteRepository.save(
                    adotante
            );
        }

        System.out.println(
                "50 adotantes gerados com sucesso."
        );



        for (int i = 0; i < 35; i++) {

            Animal animal =
                    animais.get(i);

            Adotante adotante =
                    adotantes.get(
                            faker.number()
                                    .numberBetween(
                                            0,
                                            adotantes.size()
                                    )
                    );

            Adocao adocao = Adocao.builder()
                    .animal(animal)
                    .adotante(adotante)
                    .dataAdocao(
                            LocalDate.now()
                                    .minusDays(
                                            faker.number()
                                                    .numberBetween(
                                                            0,
                                                            365
                                                    )
                                    )
                    )
                    .observacoes(
                            faker.lorem()
                                    .sentence()
                    )
                    .build();

            adocaoRepository.save(
                    adocao
            );

            animal.setStatus(
                    StatusAnimal.ADOTADO
            );

            animalRepository.save(
                    animal
            );
        }

        System.out.println(
                "35 adoções geradas com sucesso."
        );




        for (int i = 0; i < 200; i++) {

            Animal animal =
                    animais.get(
                            faker.number()
                                    .numberBetween(
                                            0,
                                            animais.size()
                                    )
                    );

            Vacinacao vacinacao = Vacinacao.builder()
                    .vacina(
                            faker.options().option(
                                    "V10",
                                    "V8",
                                    "Antirrábica",
                                    "Giárdia",
                                    "Quádrupla Felina",
                                    "Leucemia Felina"
                            )
                    )
                    .dataAplicacao(
                            LocalDate.now()
                                    .minusDays(
                                            faker.number()
                                                    .numberBetween(
                                                            0,
                                                            365
                                                    )
                                    )
                    )
                    .proximaDose(
                            LocalDate.now()
                                    .plusDays(
                                            faker.number()
                                                    .numberBetween(
                                                            30,
                                                            365
                                                    )
                                    )
                    )
                    .observacoes(
                            faker.lorem().sentence()
                    )
                    .animal(animal)
                    .build();

            vacinacaoRepository.save(
                    vacinacao
            );
        }

        System.out.println(
                "200 vacinações geradas com sucesso."
        );




        if (castracaoRepository.count() >= 45) {
            System.out.println(
                    "Castrações já cadastradas."
            );
            return;
        }

        List<Animal> animaisParaCastracao =
                new ArrayList<>(
                        animalRepository.findAll()
                                .stream()
                                .filter(animal ->
                                        !castracaoRepository
                                                .existsByAnimalId(
                                                        animal.getId()
                                                )
                                )
                                .toList()
                );

        Collections.shuffle(
                animaisParaCastracao
        );

        int quantidadeCastracoes =
                Math.min(
                        45,
                        animaisParaCastracao.size()
                );


        for (int i = 0;
             i < quantidadeCastracoes;
             i++) {

            Animal animal =
                    animaisParaCastracao.get(i);

            LocalDate dataCastracao =
                    LocalDate.now()
                            .minusDays(
                                    faker.number()
                                            .numberBetween(
                                                    0,
                                                    365
                                            )
                            );

            Castracao castracao =
                    Castracao.builder()
                            .dataCastracao(
                                    dataCastracao
                            )
                            .observacoes(
                                    faker.lorem()
                                            .sentence()
                            )
                            .animal(
                                    animal
                            )
                            .build();

            castracaoRepository.save(
                    castracao
            );
        }

        System.out.println(
                quantidadeCastracoes
                        + " castrações geradas com sucesso."
        );


         */

        if (despesaRepository.count() >= 300) {
            System.out.println(
                    "Despesas já cadastradas."
            );
            return;
        }

        List<Animal> animaisParaDespesas =
                animalRepository.findAll();

        for (int i = 0; i < 300; i++) {

            Animal animal =
                    animaisParaDespesas.get(
                            faker.number()
                                    .numberBetween(
                                            0,
                                            animaisParaDespesas.size()
                                    )
                    );

            LocalDate dataDespesa =
                    LocalDate.now()
                            .minusDays(
                                    faker.number()
                                            .numberBetween(
                                                    0,
                                                    365
                                            )
                            );

            CategoriaDespesa categoria =
                    faker.options().option(
                            CategoriaDespesa.VACINA,
                            CategoriaDespesa.MEDICAMENTO,
                            CategoriaDespesa.EXAME,
                            CategoriaDespesa.CIRURGIA,
                            CategoriaDespesa.ALIMENTACAO,
                            CategoriaDespesa.TRANSPORTE,
                            CategoriaDespesa.OUTRO
                    );

            String descricao;

            switch (categoria) {
                case VACINA ->
                        descricao = "Aplicação de vacina";

                case MEDICAMENTO ->
                        descricao = "Compra de medicamento";

                case EXAME ->
                        descricao = "Exame veterinário";

                case CIRURGIA ->
                        descricao = "Procedimento cirúrgico";

                case ALIMENTACAO ->
                        descricao = "Compra de ração";

                case TRANSPORTE ->
                        descricao = "Transporte para atendimento";

                default ->
                        descricao = "Despesa operacional";
            }

            Despesa despesa =
                    Despesa.builder()
                            .descricao(
                                    descricao
                            )
                            .categoria(
                                    categoria
                            )
                            .valor(
                                    BigDecimal.valueOf(
                                            faker.number()
                                                    .randomDouble(
                                                            2,
                                                            20,
                                                            1000
                                                    )
                                    )
                            )
                            .dataDespesa(
                                    dataDespesa
                            )
                            .observacoes(
                                    faker.lorem()
                                            .sentence()
                            )
                            .animal(
                                    animal
                            )
                            .build();

            despesaRepository.save(
                    despesa
            );
        }

        System.out.println(
                "300 despesas geradas com sucesso."
        );

    }

}
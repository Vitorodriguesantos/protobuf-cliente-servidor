package br.com.zupacademy

import io.grpc.ManagedChannelBuilder

fun main() {

    val channel = ManagedChannelBuilder
        .forAddress("localhost",50051)
        .usePlaintext()
        .build()

    val cliente = FuncionarioServiceGrpc.newBlockingStub(channel)

    val request = FuncionarioRequest.newBuilder()
        .setNome("Vitor")
        .setCpf("11122233307")
        .setIdade(26)
        .setSalario(2000.00)
        .setAtivo(true)
        .setCargo(Cargo.DEV)
        .addEnderecos(FuncionarioRequest.Endereco.newBuilder()
            .setCep("38555-066")
            .setComplemento("Esquina")
            .setNumero("44")
            .build())
        .build()

    val response = cliente.cadastrar(request)

    println(response.nome)
}
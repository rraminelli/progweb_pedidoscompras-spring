package br.com.ada.bancobrasil.pedidocompras.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProdutoImportListDto {

    private List<ProdutoImportDto> products;

}

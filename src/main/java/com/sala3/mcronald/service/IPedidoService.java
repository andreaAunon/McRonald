package com.sala3.mcronald.service;

import com.sala3.mcronald.dto.PedidoDTO;
import com.sala3.mcronald.entities.Pedido;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface IPedidoService {

    void init();
    List<PedidoDTO> getPedidos();
    void addPedido(PedidoDTO pedidoDTO);
    void deletePedido(Long idProducto);
    PedidoDTO getPedidoById(Long id);
    void updatePedido(Long id, PedidoDTO pedidoDTO);
}

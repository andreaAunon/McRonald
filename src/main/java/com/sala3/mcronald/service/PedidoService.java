package com.sala3.mcronald.service;

import com.sala3.mcronald.dto.PedidoDTO;
import com.sala3.mcronald.entities.Pedido;
import com.sala3.mcronald.entities.Trabajador;
import com.sala3.mcronald.repository.AlmacenRepository;
import com.sala3.mcronald.repository.PedidoRepository;
import com.sala3.mcronald.repository.TrabajadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoService implements IPedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private TrabajadorRepository trabajadorRepository;

    @Override
    public void init() {
        Trabajador trabajador1 = new Trabajador("Juan");
        trabajadorRepository.save(trabajador1);
        Pedido pedido1 = new Pedido(65,trabajador1);
        pedidoRepository.save(pedido1);
    }


    @Override
    public List<PedidoDTO> getPedidos() {
        List<PedidoDTO> pedidosDto = new ArrayList<>();

        for(Pedido pedido : pedidoRepository.findAll()){
            PedidoDTO pedidoDTO = pedidoToPedidoDTO(pedido);

            pedidosDto.add(pedidoDTO);
        }

        return pedidosDto;
    }

    @Override
    public void addPedido(PedidoDTO pedidoDTO) {
        Pedido pedido = pedidoDTOToPedido(pedidoDTO);
        pedidoRepository.save(pedido);
    }

    @Override
    public void deletePedido(Long idProducto) {
        pedidoRepository.deleteById(idProducto);
    }

    @Override
    public PedidoDTO getPedidoById(Long id) {
        Optional<Pedido> pedido = pedidoRepository.findById(id);
        if (pedido.isPresent()) {
            return pedidoToPedidoDTO(pedido.get());
        } else {
            return null;
        }
    }

    @Override
    public void updatePedido(Long id, PedidoDTO pedidoDTO) {

    }

    private PedidoDTO pedidoToPedidoDTO(Pedido pedido){
        PedidoDTO pedidoDto = new PedidoDTO();
        pedidoDto.setId(pedido.getIdPedido());
        pedidoDto.setImporte(pedido.getImporte());
        pedidoDto.setProductos(pedido.getProductos());
        pedidoDto.setTrabajador(pedido.getTrabajador());

        return pedidoDto;
    }

    private Pedido pedidoDTOToPedido(PedidoDTO pedidoDTO){
        Pedido pedido = new Pedido();
        pedidoDTO.setId(pedido.getIdPedido());
        pedidoDTO.setImporte(pedido.getImporte());
        pedidoDTO.setProductos(pedido.getProductos());
        pedidoDTO.setTrabajador(pedido.getTrabajador());

        return pedido;
    }
}

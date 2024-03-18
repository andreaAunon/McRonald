package com.sala3.mcronald.controller;

import com.sala3.mcronald.dto.PedidoDTO;
import com.sala3.mcronald.service.IPedidoService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value="pedido")
public class PedidoController {

    @Autowired
    private IPedidoService pedidoService;

    @PostConstruct
    @PostMapping("/init")
    public String crearPedidosBase(){
        pedidoService.init();
        return "Ok";
    }

    @GetMapping("/listar")
    @ResponseBody
    public void getPedidos(Model model){
        model.addAttribute("pedidos", pedidoService.getPedidos());
    }

    @GetMapping("/add")
    @ResponseBody
    public void addPedido(Model model){
        PedidoDTO pedido = new PedidoDTO();
        pedidoService.addPedido(pedido);
        model.addAttribute("pedidos", pedidoService.getPedidos());
    }


    @PutMapping(value = "/actualizar")
    @ResponseBody
    public void updatePedido(@PathVariable Long idPedido, @RequestBody PedidoDTO pedidoDTO,
                             Model model) {
        PedidoDTO pedidoAActualizar = pedidoService.getPedidoById(idPedido);

        if(pedidoAActualizar != null){
            pedidoService.updatePedido(idPedido,pedidoDTO);
        } else {
            pedidoService.addPedido(pedidoDTO);
        }

        model.addAttribute("pedidos", pedidoService.getPedidos());
    }

    @DeleteMapping(value = "/borrar/{idPedido}")
    @ResponseBody
    public void deletePedido(@PathVariable Long idProducto, Model model) {
        pedidoService.deletePedido(idProducto);
        model.addAttribute("pedidos", pedidoService.getPedidos());
    }

}

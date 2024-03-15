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
    @PostMapping("/pedido/init")
    public String crearPedidosBase(){
        pedidoService.init();
        return "Ok";
    }

    @GetMapping("/list")
    @ResponseBody
    public void getPedidos(Model model){
        model.addAttribute("pedidosList", pedidoService.getPedidos());
    }


    @PutMapping(value = "/pedidos/{idPedido}")
    public String updatePedido(@PathVariable Long idPedido, @RequestBody PedidoDTO pedidoDTO) {
        PedidoDTO pedidoAActualizar = pedidoService.getPedidoById(idPedido);

        if(pedidoAActualizar != null){
            pedidoService.updatePedido(idPedido,pedidoDTO);
        } else {
            pedidoService.addPedido(pedidoDTO);
        }

        return "redirect:/pedidos/list";
    }

    @DeleteMapping(value = "/pedidos/{idPedido}")
    public String deletePedido(@PathVariable Long idProducto) {
        pedidoService.deletePedido(idProducto);
        return "redirect:/pedidos/list";
    }

}

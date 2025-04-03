package com.prova.services;

import com.prova.dtos.MovimentoDTO;
import com.prova.models.Movimento;
import com.prova.repositories.MovimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;

@Service
public class MovimentoService {

    @Autowired
    private MovimentoRepository movimentoRepository;

    public MovimentoDTO salvarMovimento(MovimentoDTO movimentoDTO) {
       Movimento movimento = converterMovimentoDTOParaMovimento(movimentoDTO);
       movimento = movimentoRepository.save(movimento);
       return converterMovimentoParaMovimentoDTO(movimento);
    }

    private Movimento converterMovimentoDTOParaMovimento(MovimentoDTO movimentoDTO) {
        Movimento movimento = new Movimento();
        movimento.setId(movimentoDTO.getId());
        movimento.setData_movimento(movimentoDTO.getData_movimento());
        movimento.setValor(movimentoDTO.getValor());
        movimento.setClassificacao(movimentoDTO.getClassificacao());
        movimento.setObservacao(movimentoDTO.getObservacao());
        return movimento;
    }

    public MovimentoDTO converterMovimentoParaMovimentoDTO(Movimento movimento) {
        MovimentoDTO movimentoDTO = new MovimentoDTO();
        movimentoDTO.setId(movimento.getId());
        movimentoDTO.setData_movimento(movimento.getData_movimento());
        movimentoDTO.setValor(movimento.getValor());
        movimentoDTO.setClassificacao(movimento.getClassificacao());
        movimentoDTO.setObservacao(movimento.getObservacao());
        return movimentoDTO;
    }

    public Movimento buscarMovimentoPorId(Long id) {
        return movimentoRepository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Movimento não encontrado"));
    }

    public MovimentoDTO atualizarMovimento(MovimentoDTO movimentoDTO) {
        if (isNull(movimentoDTO.getId())) {
            throw new IllegalArgumentException("campo Id não informado");
        }
        Movimento movimento = movimentoRepository.findById(movimentoDTO.getId())
                .orElseThrow(() ->
                        new IllegalArgumentException("Movimento não encontrado"));

        movimento = converterMovimentoDTOParaMovimento(movimentoDTO);
        movimento = movimentoRepository.save(movimento);

        return converterMovimentoParaMovimentoDTO(movimento);
    }

    public void deletarMovimento(Long id) {
        movimentoRepository.deleteById(id);
    }

}

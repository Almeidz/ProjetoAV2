
package controller;

import model.Funcionario;

import java.util.ArrayList;
import java.util.List;

public class FuncionarioController {
    private List<Funcionario> funcionarios;

    public FuncionarioController() {
        this.funcionarios = new ArrayList<>();
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public List<Funcionario> listarFuncionarios() {
        return funcionarios;
    }

    public Funcionario buscarFuncionario(String nome) {
        for (Funcionario f : funcionarios) {
            if (f.getNome().equalsIgnoreCase(nome)) {
                return f;
            }
        }
        return null;
    }

    public boolean removerFuncionario(String nome) {
        Funcionario funcionario = buscarFuncionario(nome);
        if (funcionario != null) {
            funcionarios.remove(funcionario);
            return true;
        }
        return false;
    }
}

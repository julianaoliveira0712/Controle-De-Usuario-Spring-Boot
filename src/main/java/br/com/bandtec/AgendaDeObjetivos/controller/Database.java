package br.com.bandtec.AgendaDeObjetivos.controller;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class Database {
    public static Database database;
    private JdbcTemplate jdbcTemplate ;
    private BasicDataSource dataSource;

    public Database() {
        dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        dataSource.setUrl("jdbc:sqlserver://servercarbontower.database.windows.net:1433;database=carbontower;user=tower@servercarbontower;password=!Carbon6;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
        dataSource.setUsername("tower");
        dataSource.setPassword("!Carbon6");

        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void insertUsuario(Usuario usuario) {
        jdbcTemplate.update("insert into Users (name, username, password) values (?,?,?)",
                usuario.getNome(), usuario.getLogin(), usuario.getSenha()
        );
    }

    public Usuario selectUsuario(Credenciais usuario) {

        List<Usuario> usuarioSelecionado = jdbcTemplate.query("select * from Users where username ='" +usuario.getUsuario()+"'",
                new BeanPropertyRowMapper(Usuario.class));

        return usuarioSelecionado.get(0);
    }

    public boolean validarLogin(Credenciais login) {
        List<Map<String, Object>> usuario = jdbcTemplate.queryForList("select * from Users where username= '" + login.getUsuario() + "' and password = '" + login.getSenha() + "'");
        return usuario.size() != 0;
    }

    public boolean existeUsuario(Usuario novoUsuario) {
        List<Map<String, Object>> listaUsuarios = jdbcTemplate.queryForList("select * from Users where username = '" + novoUsuario.getLogin() + "'");
        return !listaUsuarios.isEmpty();
    }
}

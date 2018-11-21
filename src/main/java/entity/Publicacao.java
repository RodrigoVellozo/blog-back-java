package entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Publicacao {

	public static SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private Integer id;
	private String titulo;
	private String texto;
	private Date data = new Date();
	private String imagem;
	
	private Usuario usuario;
	
		
	public Publicacao() {
		
		
	}
	public Publicacao(Integer id, String titulo, String texto, String imagem) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.texto = texto;
		this.imagem = imagem;
		
	}
	
	@Override
	public String toString() {
		return "Publicacao [id=" + id + ", titulo=" + titulo + ", texto=" + texto + ", data= " + SDF.format(data) + ", imagem="
				+ imagem + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getImagem() {
		return imagem;
	}
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	

}

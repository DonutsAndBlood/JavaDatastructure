package arvore;

import dados.Item;

public class Arvore {
	private NoArv raiz;
	private int quantNos;//opcional

	public Arvore(){
		this.quantNos=0;
		this.raiz = null;
	}
	public boolean eVazia (){
		return (this.raiz == null);
	}
	public NoArv getRaiz(){
		return this.raiz;
	}
	public int getQuantNos(){
		return this.quantNos;
	}
	
	
	
	
	//inserir um novo n� na arvore. Sempre insere em um atributo que seja igual a null
	public boolean inserir (Item elem){
		
		if (pesquisarNome (elem.getNome())){
			return false;
		}else{
			
			if(pesquisarCpf(elem.getCpf(),elem.getNome())) {
				return false;
			}else {
			
			this.raiz = inserir (elem, this.raiz);
			this.quantNos++;
			return true;
		}
	}
	}
	
	public NoArv inserir (Item elem, NoArv no){
		if (no == null){
			NoArv novo = new NoArv(elem);
			return novo;
		}else {
			if (elem.getNome().compareTo(no.getInfo().getNome()) < 0){
				no.setEsq(inserir(elem, no.getEsq()));
				return no;
			}else{
				no.setDir(inserir(elem, no.getDir()));
				return no;
			}
		}
	}
	
	
	
	//elem.getNome() < no.getInfo().getNome()
	
	//Pesquisa se um determinado nome est� na �rvore
	public boolean pesquisarNome (String chave){
		if (pesquisarNome (chave, this.raiz)!= null){
			return true;//achou
		}else{
			return false;//n�o achou
		}
	}
	
	
	private NoArv pesquisarNome (String chave, NoArv no){
		if (no != null){
			if (chave.compareTo(no.getInfo().getNome()) < 0){
				no = pesquisarNome (chave, no.getEsq());
				System.out.println("primeiro if");
			}else{
				if (chave.compareTo(no.getInfo().getNome()) > 0){
					no = pesquisarNome (chave, no.getDir());
					System.out.println("segundo if");
				}
			}
		}
		return no;
	}
	
	public boolean pesquisarCpf (String cpf, String nome){
		if (pesquisarCpf (cpf, this.raiz) != null){
			System.out.println("Entrou achou");
			return true;//achou
		}else{
			System.out.println("Entrou n achou");
			return false;//n�o achou
		}
	}
	
	
	private NoArv pesquisarCpf (String cpf, NoArv no){
		if (no != null){
			if (cpf.compareTo(no.getInfo().getCpf()) < 0 ){
					no = pesquisarCpf(cpf,no.getEsq());
				}
			
		    if (cpf.compareTo(no.getInfo().getCpf()) > 0){
		    no = pesquisarCpf(cpf,no.getDir());
		    }	
					
				}	
		return no;
	}
	
	
	
	
	
	
	
	public String mostrarDados(String nom) {
		
		String nome = nom;
		String cpf = "";
		String telefone = "";
		String email = "";
		Double saldo = 0.0;
		String mensagem;
		NoArv no;
		
		no = pesquisarNome(nom,this.raiz);
		
	
		
		mensagem = ("Nome: "+no.getInfo().getNome()+"\n"
				         + "CPF: "+no.getInfo().getCpf()+"\n"
				         +"Telefone: "+no.getInfo().getTelefone()+"\n"
				         +"E-Mail: "+no.getInfo().getEmail()+"\n"
				         +"Saldo: "+no.getInfo().getSaldo());
		
		return mensagem;
	}
	
	
	public static String ordenarAlfabetico(Arvore arvore) {
		
		Item[] listaItems = arvore.CamPreFixado();
		String mensagem = "";
		Item aux;
		
		for (int i = 0; i < arvore.quantNos; i++) {
            for (int j = i + 1; j < arvore.quantNos; j++) {
               
                if (listaItems[i].getNome().compareTo(listaItems[j].getNome()) > 0) {
                    aux = listaItems[i];
                    listaItems[i] = listaItems[j];
                    listaItems[j] = aux;
                    
                }
            }
		}
		
		int x = arvore.getQuantNos();
	
        for (int p = 0; p < x; p++) {
        	
            mensagem += (p+1)+"."+listaItems[p].getNome()+"\n";
            
        }
		
		return mensagem;
	}
     
	
public static Double mediaAritimetica(Arvore arvore) {
		
		Item[] listaItems = arvore.CamPreFixado();
		Double saldoTotal = 0.0;
		Double media = 0.0;
		
		
		for (int i = 0; i < arvore.quantNos; i++) {
			
			saldoTotal += listaItems[i].getSaldo();
			
		}
           
		media = saldoTotal/arvore.quantNos;
		
		return media;
        }

public static String maiorSaldo(Arvore arvore) {
	
	Item[] listaItems = arvore.CamPreFixado();
	Double maiorSaldo = 0.0;
	Double media = 0.0;
	String mensagem = "";
	
	
	for (int i = 0; i < arvore.quantNos; i++) {
		
		if (listaItems[i].getSaldo() > maiorSaldo) {
			
			maiorSaldo = listaItems[i].getSaldo();
			mensagem = "O maior saldo é do cliente: "+listaItems[i].getNome()+"-"+maiorSaldo+" Reais";
		}	
	}
	
	return mensagem;
    }
		
	
	/*
	///remove um determinado n� procurando pela chave. O n� pode estar em qualquer
	//posi��o na �rvore
	public boolean remover (String chave){
		if (pesquisar (chave, this.raiz) != null){
			this.raiz = remover (chave, this.raiz);
			this.quantNos--;
			return true;
		}
		else {
			return false;
		}
	}
	public NoArv remover (String chave, NoArv arv){
		if (chave < arv.getInfo().getNome()){
			arv.setEsq(remover (chave, arv.getEsq()));
		}else{
			if (chave > arv.getInfo().getNome()){
				arv.setDir(remover (chave, arv.getDir()));
			}else{
				if (arv.getDir()== null){
					return arv.getEsq();
				}else{
					if (arv.getEsq() == null){ 
						return arv.getDir();
					}else{
						arv.setEsq(Arrumar (arv, arv.getEsq()));
					}
				}
			}
		}
		return arv;
	}
	*/
	
	
	private NoArv Arrumar (NoArv arv, NoArv maior){
		if (maior.getDir() != null){
			maior.setDir(Arrumar (arv, maior.getDir()));
		}
		else{
			arv.setInfo(maior.getInfo());
			maior = maior.getEsq();
		}
		return maior;
	}
	//caminhamento central
	public Item [] CamCentral (){
		int []n= new int[1];
		n[0]=0;
		Item [] vet = new Item[this.quantNos];
		return (FazCamCentral (this.raiz, vet, n));
	}
	private Item [] FazCamCentral (NoArv arv, Item [] vet, int []n){
		if (arv != null) {
			vet = FazCamCentral (arv.getEsq(),vet,n);
			vet[n[0]] = arv.getInfo();
			n[0]++;
			vet = FazCamCentral (arv.getDir(),vet,n);
		}
		return vet;
	}
	
	
	//caminhamento pre-fixado
	public Item [] CamPreFixado (){
		int []n= new int[1];
		n[0]=0;
		Item [] vet = new Item[this.quantNos];
		return (FazCamPreFixado (this.raiz, vet, n));
	}
	
	private Item [] FazCamPreFixado (NoArv arv, Item [] vet, int []n){
		if (arv != null) {

			vet[n[0]] = arv.getInfo();
			n[0]++;

			vet = FazCamPreFixado (arv.getEsq(), vet,n);
			vet = FazCamPreFixado (arv.getDir(), vet,n);
		}
		return vet;
	}
	
	
	//caminhamento p�s-fixado
	public Item [] CamPosFixado (){
		int []n= new int[1];
		n[0]=0;
		Item [] vet = new Item[this.quantNos];
		return (FazCamPosFixado (this.raiz, vet, n));
	}
	private Item [] FazCamPosFixado (NoArv arv, Item[] vet, int []n){
		if (arv != null) {
			vet = FazCamPosFixado (arv.getEsq(), vet,n);
			vet = FazCamPosFixado (arv.getDir(), vet,n);
			vet[n[0]] = arv.getInfo();
			n[0]++;
		}
		return vet;
	}

}

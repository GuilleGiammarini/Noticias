
package com.Egg.noticias.entidades;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@DiscriminatorValue("PERIODISTA")
@Getter
@Setter
@NoArgsConstructor 
public class Periodista extends Usuario{
    
    @OneToMany(mappedBy="creador")
    private List<Noticia> misNoticias;
    
   
    private Integer sueldoMensual;

}


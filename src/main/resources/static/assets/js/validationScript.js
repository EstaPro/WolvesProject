var oldmdp = null; 

//Validation nom et prenom
function valider_string(elem)
{
	//Declaration d'une expression regulière
	var exp = new RegExp("^[a-zA-Z]+$", "g");
	//Declaration
	var val = elem.value;
	var span = elem.parentNode.childNodes[3];
	span.innerHTML="";
	span.style.display="none";
	//Validation
	//Teste resultat validation
	if(val.length==0)
	{
		elem.style.border="3px solid red";
		span.innerHTML=elem.name+" obligatoire";
		span.style.display="block";
		return false;
	}
	else
	if(val.length>20)
	{
		elem.style.border="3px solid red";
		span.innerHTML=elem.name+" est très long";
		span.style.display="block";
		return false;
	}
	else
	if(!exp.test(val))
	{
		elem.style.border="3px solid red";
		span.innerHTML=elem.name+" invalide";
		span.style.display="block";
		return false;
	}
	else
	{
		elem.style.border="1px solid green";
		span.innerHTML="";
		span.style.display="none";
		return true;
	}
}

//Email
function valide_email(elem)
{
	//Declaration d'une expression regulière
	var email = /([\w-\.]+@[\w\.]+\.{1}[\w]+)/;
	//Declaration
	var val = elem.value;
	var span = elem.parentNode.childNodes[5];
	span.innerHTML="";
	span.style.display="none";
	//Validation
	//Teste resultat validation
	if(val.length==0)
	{
		elem.style.border="1px solid red";
		span.innerHTML="email obligatoire";
		span.style.display="block";
		return false;
	}
	else
	if(val.length<5)
	{
		elem.style.border="1px solid red";
		span.innerHTML="email très court";
		span.style.display="block";
		return false;
	}
	else
	if(!email.test(val))
	{
		elem.style.border="1px solid red";
		span.innerHTML="email invalide";
		span.style.display="block";
		return false;
	}
	else
	{
		elem.style.border="1px solid green";
		span.innerHTML="";
		span.style.display="none";
		return true;
	}
}

//Valider date
function ckeckDate(date)
{
	//SI la taille de la date et inf à 10 return false;
	if(date.length!=10) return false;
	//Vérification des index de -
	var ind1 = date.indexOf("-");
	var ind2 = date.lastIndexOf("-");
	if(ind1!=2 || ind2!=5) return false;
	//Recuprer le jour, le mois, l'année
		var day = parseInt(date.slice(0, 2));
		var month   = parseInt(date.slice(3, 5));
	var year  = parseInt(date.slice(6, 10));
	//Teste des jours, mois et années
		if((month < 1) || (month > 12)) return false;
		else if((day < 1) || (day > 31)) return false;
		else if(((month == 4) || (month == 6) || (month == 9) || (month == 11)) && (day > 30)) return false;
		else if((month == 2) && (((year % 400) == 0) || ((year % 4) == 0)) && ((year % 100) != 0) && (day > 29)) return false;
	else if((month == 2) && ((year % 100) == 0) && (day > 29)) return false;
	else if((month == 2) && (day > 28)) return false;
	return true;
}

function valide_date(elem)
{
	//Declaration
	var val = elem.value;
	var span = elem.parentNode.childNodes[3];
	span.innerHTML="";
	span.style.display="none";
	//Validation
	//Teste resultat validation
	if(val.length==0)
	{
		elem.style.border="3px solid red";
		span.innerHTML="* date obligatoire";
		span.style.display="block";
		return false;
	}
	else
	if(val.length<10)
	{
		elem.style.border="3px solid red";
		span.innerHTML="* date est très courte";
		span.style.display="block";
		return false;
	}
	else
	if(!ckeckDate(val))
	{
		elem.style.border="3px solid red";
		span.innerHTML="* date invalide";
		span.style.display="block";
		return false;
	}
	else
	{
		elem.style.border="3px solid green";
		span.innerHTML="";
		span.style.display="none";
		return false;
	}
}

function valide_numero(elem)
{
	//Expression regu
	var numero = new RegExp("^[0-9]+$", "g");
	//Declaration
	var val = elem.value;
	var span = elem.parentNode.childNodes[5];
	span.innerHTML="";
	span.style.display="none";
	//Validation
	//Teste resultat validation
	if(val.length==0)
	{
		elem.style.border="1px solid red";
		span.innerHTML="numéro tel obligatoire";
		span.style.display="block";
		return false;
	}
	else
	if(val.length<10)
	{
		elem.style.border="1px solid red";
		span.innerHTML="numéro très courte";
		span.style.display="block";
		return false;
	}
	else
	if(val.length>10)
	{
		elem.style.border="1px solid red";
		span.innerHTML="numero très long";
		span.style.display="block";
		return false;
	}
	else
	if( (val[0]!=0 || (val[1]!=5 && val[1]!=6) ) || !numero.test(val) )
	{
		elem.style.border="1px solid red";
		span.innerHTML="numéro invalide";
		span.style.display="block";
		return false;
	}
	else
	{
		elem.style.border="1px solid green";
		span.innerHTML="";
		span.style.display="none";
		return true;
	}
}


function valide_mdp(elem)
{
    
    oldmdp=elem;
	//Declaration
	var val = elem.value;
	var span = elem.parentNode.childNodes[5];
	span.innerHTML="";
	span.style.display="none";
	//Validation
	//Teste resultat validation
	if(val.length==0)
	{
		elem.style.border="1px solid red";
		span.innerHTML="mot de passe obligatoire";
		span.style.display="block";
		return false;
	}
	else
	if(val.length<6)
	{
		elem.style.border="1px solid red";
		span.innerHTML="mot de passe très courte";
		span.style.display="block";
		return false;
	}
	else
	{
		elem.style.border="1px solid green";
		span.innerHTML="";
		span.style.display="none";
		return true;
	}
}

function valide_mdp_con(old,nv)
{
	//old mot de passe
	var oldval = old.value;
	//Nouveau mot de passe
	var newval = nv.value;
	var newspan = nv.parentNode.childNodes[5];
	if(oldval.length>0)
	{
		if(newval.length==0)
		{
			nv.style.border="1px solid red";
			newspan.innerHTML="champ obligatoire";
			newspan.style.display="block";
			return false;
		}
		else
		if(oldval != newval)
		{
			nv.style.border="1px solid red";
			newspan.innerHTML="mots de passe ne correspond pas";
			newspan.style.display="block";
			return false;
		}
		else
		{
			nv.style.border="1px solid green";
			newspan.innerHTML="";
			newspan.style.display="none";
			return false;
		}
	}
	else
	{
		valide_mdp(old);
		nv.style.border="1px solid red";
		newspan.innerHTML="champ obligatoire";
		newspan.style.display="block";
		return true;
	}
}

//Retirer style
function retirer_style(elem)
{
	elem.style.border="1px solid #ccc;";
	var span = elem.parentNode.childNodes[5];
	span.innerHTML="";
	span.style.display="none";
}

//Traitement image
function valider_image(elem)
{
	//Recuperer l'image
	var img = elem.files[0];
	var span = elem.parentNode.childNodes[3];
	//retirer les erreurs
	/*span.innerHTML="Fichier trop gros";
	span.style.display="block";
	//Traitement de l'image
	if(parseFloat(img.size))
	{
		span.innerHTML=" * Fichier trop gros";
		span.style.display="block";
		return false;
	}
	else
	{
		
	}*/
	span.innerHTML="<img style='height: 200px;width: 200px' src='"+img.name+"'>";
	span.style.display="block";
	//File reader
	var reader = new FileReader();
    reader.addEventListener('load', function() {
    	//attante
    	if (reader.readyState == 1) 
    	{
    		span.innerHTML="Chargement en cours";
    		span.style.display="block";
    	}
    	if (reader.readyState == 2) 
    	{
    		span.innerHTML="";
    		span.style.display="none";
    		var imgElement = document.createElement('img');
    	    imgElement.style.maxWidth = '150px';
    	    imgElement.style.maxHeight = '150px';
    	    imgElement.src = this.result;
    	    elem.parentNode.appendChild(imgElement);
    	}
    });
}


# AgentesInteligentes2015

Pasos para configurar git:
Windows: abrir git shell(instalar https://windows.github.com/)
Mac: abrir terminal

ahora en la git shell o en la terminal de mac ir a un directorio con el comando cd
por ejemplo 'Documents'.

Crear carpeta 'GitHub' con mkdir, entrar a la carpeta que creamos y usar el comando:
git clone https://github.com/djmacky/AgentesInteligentes2015

(ese es el repositorio que ya tengo creado para el curso)

se va a copiar el repositorio a su carpeta local, despues tenemos que entrar a la carpeta
igualmente con el comando cd 'AgentesInteligentes2015'

paso 1, para todos tener la misma version del proyecto, 
ejecutar los siguientes comandos en el orden expuesto:

git status 
git pull

les dejo abajo algunos otros comandos que estaremos usando para hacer el push, el commit, etc...

dentro de nuestro repositorio podemos ejecutar los siguientes comandos:

git status: shows the difference of all the shared projects 

git add 'nameoffile.java'
 - variants: git add . or git add -A : this will add all items on directory 

git commit -m "message here to commit changes by using the previous command"

git push: push the commited files to github.com ;)

git pull: pull from github.com to your local folder ;)

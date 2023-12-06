# Define o provedor AWS
provider "aws" {
  region = "us-east-1"
}

# Define variáveis
variable "commit_hash" {
  description = "Hash do commit para identificar a versão da imagem Docker"
}

variable "ssh_private_key_path" {
  description = "Caminho para a chave privada SSH"
}

# Define a instância EC2
resource "aws_instance" "server1" {
  ami           = "ami-0a313d6098716f372"
  instance_type = "t2.micro"

  tags = {
    Name     = "Ubuntu-1"
    Ambiente = "Desenvolvimento"
  }

  provisioner "remote-exec" {
    inline = [
      "sudo apt-get update",
      "sudo apt-get install -y docker.io",
      "sudo docker pull viniciom/csg3-painelatualizacoesacademicas:${var.commit_hash}",
      "sudo docker run -d -p 80:80 viniciom/csg3-painelatualizacoesacademicas:${var.commit_hash}",
    ]

    connection {
      type        = "ssh"
      user        = "ec2-user"
      private_key = file(var.ssh_private_key_path)
      host        = self.public_ip
    }
  }
}

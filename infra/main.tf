#Define chaves e região
provider "aws" {
  region     = "us-east-1"
}

#Define a instância EC2
resource "aws_instance" "server1" {
  ami           = "ami-0a313d6098716f372"
  instance_type = "t2.micro"

  tags = {
    Name     = "Ubuntu-1"
    Ambiente = "Desenvolvimento"
  }
}

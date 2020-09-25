data "aws_ami" "default" {
  most_recent = true

  filter {
    name   = "name"
    values = ["ubuntu/images/hvm-ssd/ubuntu-focal-20.04-amd64-server-*"]
  }

  filter {
    name   = "virtualization-type"
    values = ["hvm"]
  }

  owners = ["099720109477"] # Canonical
}

resource "aws_datapipeline_pipeline" "default" {
  instance_type    = var.instance_type
  key_name         = var.key_name
  ami              = data.aws_ami.default.id
  filename = "../build/libs/demo-1.0.0.jar"
  function_name = "demo"
  description = "demo"
  runtime = "java11"
  timeout = "60"
  memory_size = 512
}
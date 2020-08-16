using System;

namespace API.Domain.Entities
{

    public class UpDateTaskRequest
	{
		public string Nome { get; set; }
		public Guid Id { get; set; }
		public bool Done { get; set; }
	}
}

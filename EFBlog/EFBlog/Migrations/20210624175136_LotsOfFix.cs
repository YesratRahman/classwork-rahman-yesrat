using Microsoft.EntityFrameworkCore.Migrations;

namespace EFBlog.Migrations
{
    public partial class LotsOfFix : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.RenameColumn(
                name: "BlogUserId",
                table: "Users",
                newName: "id");
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.RenameColumn(
                name: "id",
                table: "Users",
                newName: "BlogUserId");
        }
    }
}

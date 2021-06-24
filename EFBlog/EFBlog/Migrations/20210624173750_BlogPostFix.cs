using Microsoft.EntityFrameworkCore.Migrations;

namespace EFBlog.Migrations
{
    public partial class BlogPostFix : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.RenameColumn(
                name: "BlogPostId",
                table: "Posts",
                newName: "id");
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.RenameColumn(
                name: "id",
                table: "Posts",
                newName: "BlogPostId");
        }
    }
}

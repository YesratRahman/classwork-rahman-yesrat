using Microsoft.EntityFrameworkCore.Migrations;

namespace EFBlog.Migrations
{
    public partial class UserTableChange : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropForeignKey(
                name: "FK_Comments_BlogUsers_AuthorBlogUserId",
                table: "Comments");

            migrationBuilder.DropForeignKey(
                name: "FK_Posts_BlogUsers_AuthorBlogUserId",
                table: "Posts");

            migrationBuilder.DropPrimaryKey(
                name: "PK_BlogUsers",
                table: "BlogUsers");

            migrationBuilder.RenameTable(
                name: "BlogUsers",
                newName: "Users");

            migrationBuilder.AddPrimaryKey(
                name: "PK_Users",
                table: "Users",
                column: "BlogUserId");

            migrationBuilder.AddForeignKey(
                name: "FK_Comments_Users_AuthorBlogUserId",
                table: "Comments",
                column: "AuthorBlogUserId",
                principalTable: "Users",
                principalColumn: "BlogUserId",
                onDelete: ReferentialAction.Restrict);

            migrationBuilder.AddForeignKey(
                name: "FK_Posts_Users_AuthorBlogUserId",
                table: "Posts",
                column: "AuthorBlogUserId",
                principalTable: "Users",
                principalColumn: "BlogUserId",
                onDelete: ReferentialAction.Restrict);
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropForeignKey(
                name: "FK_Comments_Users_AuthorBlogUserId",
                table: "Comments");

            migrationBuilder.DropForeignKey(
                name: "FK_Posts_Users_AuthorBlogUserId",
                table: "Posts");

            migrationBuilder.DropPrimaryKey(
                name: "PK_Users",
                table: "Users");

            migrationBuilder.RenameTable(
                name: "Users",
                newName: "BlogUsers");

            migrationBuilder.AddPrimaryKey(
                name: "PK_BlogUsers",
                table: "BlogUsers",
                column: "BlogUserId");

            migrationBuilder.AddForeignKey(
                name: "FK_Comments_BlogUsers_AuthorBlogUserId",
                table: "Comments",
                column: "AuthorBlogUserId",
                principalTable: "BlogUsers",
                principalColumn: "BlogUserId",
                onDelete: ReferentialAction.Restrict);

            migrationBuilder.AddForeignKey(
                name: "FK_Posts_BlogUsers_AuthorBlogUserId",
                table: "Posts",
                column: "AuthorBlogUserId",
                principalTable: "BlogUsers",
                principalColumn: "BlogUserId",
                onDelete: ReferentialAction.Restrict);
        }
    }
}

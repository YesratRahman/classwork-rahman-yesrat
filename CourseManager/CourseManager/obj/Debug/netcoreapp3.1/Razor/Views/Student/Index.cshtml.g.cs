#pragma checksum "/Users/yesratrahman/Desktop/TalentPath/classwork-rahman-yesrat/CourseManager/CourseManager/Views/Student/Index.cshtml" "{ff1816ec-aa5e-4d10-87f7-6f4963833460}" "d78e0f931cc5b8c49dc008b968fb27a1b24ff3bf"
// <auto-generated/>
#pragma warning disable 1591
[assembly: global::Microsoft.AspNetCore.Razor.Hosting.RazorCompiledItemAttribute(typeof(AspNetCore.Views_Student_Index), @"mvc.1.0.view", @"/Views/Student/Index.cshtml")]
namespace AspNetCore
{
    #line hidden
    using System;
    using System.Collections.Generic;
    using System.Linq;
    using System.Threading.Tasks;
    using Microsoft.AspNetCore.Mvc;
    using Microsoft.AspNetCore.Mvc.Rendering;
    using Microsoft.AspNetCore.Mvc.ViewFeatures;
#nullable restore
#line 1 "/Users/yesratrahman/Desktop/TalentPath/classwork-rahman-yesrat/CourseManager/CourseManager/Views/_ViewImports.cshtml"
using CourseManager;

#line default
#line hidden
#nullable disable
#nullable restore
#line 2 "/Users/yesratrahman/Desktop/TalentPath/classwork-rahman-yesrat/CourseManager/CourseManager/Views/_ViewImports.cshtml"
using CourseManager.Models;

#line default
#line hidden
#nullable disable
    [global::Microsoft.AspNetCore.Razor.Hosting.RazorSourceChecksumAttribute(@"SHA1", @"d78e0f931cc5b8c49dc008b968fb27a1b24ff3bf", @"/Views/Student/Index.cshtml")]
    [global::Microsoft.AspNetCore.Razor.Hosting.RazorSourceChecksumAttribute(@"SHA1", @"870e09f90f628899fb5293e1937c64ef3e3d7d37", @"/Views/_ViewImports.cshtml")]
    public class Views_Student_Index : global::Microsoft.AspNetCore.Mvc.Razor.RazorPage<IEnumerable<Student>>
    {
        #pragma warning disable 1998
        public async override global::System.Threading.Tasks.Task ExecuteAsync()
        {
            WriteLiteral("\n<table>\n\n");
#nullable restore
#line 7 "/Users/yesratrahman/Desktop/TalentPath/classwork-rahman-yesrat/CourseManager/CourseManager/Views/Student/Index.cshtml"
     foreach (Student s in Model)
    {

#line default
#line hidden
#nullable disable
            WriteLiteral("    <tr>\n        <td>");
#nullable restore
#line 10 "/Users/yesratrahman/Desktop/TalentPath/classwork-rahman-yesrat/CourseManager/CourseManager/Views/Student/Index.cshtml"
       Write(Html.ActionLink(s.Name, "Details", new { id = s.Id }));

#line default
#line hidden
#nullable disable
            WriteLiteral("</td>\n        <td>");
#nullable restore
#line 11 "/Users/yesratrahman/Desktop/TalentPath/classwork-rahman-yesrat/CourseManager/CourseManager/Views/Student/Index.cshtml"
       Write(Html.ActionLink("Edit", "Edit", new { id = s.Id }));

#line default
#line hidden
#nullable disable
            WriteLiteral("</td>\n        <td>");
#nullable restore
#line 12 "/Users/yesratrahman/Desktop/TalentPath/classwork-rahman-yesrat/CourseManager/CourseManager/Views/Student/Index.cshtml"
       Write(Html.ActionLink("Delete", "Delete", new { id = s.Id }));

#line default
#line hidden
#nullable disable
            WriteLiteral("</td>\n    </tr>\n");
#nullable restore
#line 14 "/Users/yesratrahman/Desktop/TalentPath/classwork-rahman-yesrat/CourseManager/CourseManager/Views/Student/Index.cshtml"
    }

#line default
#line hidden
#nullable disable
            WriteLiteral("</table>");
        }
        #pragma warning restore 1998
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.ViewFeatures.IModelExpressionProvider ModelExpressionProvider { get; private set; }
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.IUrlHelper Url { get; private set; }
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.IViewComponentHelper Component { get; private set; }
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.Rendering.IJsonHelper Json { get; private set; }
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.Rendering.IHtmlHelper<IEnumerable<Student>> Html { get; private set; }
    }
}
#pragma warning restore 1591
